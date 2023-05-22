package com.prior.grpc.Service;

import com.google.protobuf.ByteString;
import com.prior.grpc.models.ResponseModel;
import com.prior.grpc.proto.ClassRoomServiceGrpc;
import com.prior.grpc.proto.FileServiceGrpc;
import com.prior.grpc.proto.HelloServiceGrpc;
import com.prior.grpc.proto.Test;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
public class UserService {


    public ResponseModel<String> getHello(Map<String, String> body) {
        ResponseModel<String> response = new ResponseModel<>();
        response.setStatus(200);
        response.setDescription("ok");
        response.setTimeStamp(LocalDate.now());
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        try {
            HelloServiceGrpc.HelloServiceBlockingStub stub
                    = HelloServiceGrpc.newBlockingStub(channel);

            Test.HelloResponse helloResponse = stub.hello(Test.HelloRequest.newBuilder()
                    .setFirstName(body.get("first_name"))
                    .setLastName(body.get("last_name"))
                    .build());

            System.out.println("helloResponse " + helloResponse.toString());
            response.setData(helloResponse.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(500);
            response.setDescription("error : " + ex.getMessage());
        }

        channel.shutdown();
        return response;
    }
    public ResponseModel<String> uploadFile(MultipartFile file) {
        ResponseModel<String> response = new ResponseModel<>();
        response.setStatus(200);
        response.setDescription("ok");
        response.setTimeStamp(LocalDate.now());
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        FileServiceGrpc.FileServiceStub fileServiceStub = FileServiceGrpc.newStub(channel);
        String fileName = file.getOriginalFilename();
        System.out.println("filename : " + file.getOriginalFilename());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        StreamObserver<Test.FileChunk> statusOfFileUpload = fileServiceStub.uploadFiles(new StreamObserver<Test.UploadStatus>() {
            @Override
            public void onNext(Test.UploadStatus uploadStatus) {
                System.out.println("inside onNext : " + uploadStatus);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error :" + throwable.getMessage());
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
                countDownLatch.countDown();

            }
        });
        byte[] buffer = new byte[5120];

        int length;
        try {
            InputStream inputStream = file.getInputStream();
            while ((length = inputStream.read(buffer)) > 0) {
                var request = Test.FileChunk.newBuilder().setName(
                        Test.FileName.newBuilder().setName(fileName).build()
                ).setFile(
                        Test.File.newBuilder().setContent(ByteString.copyFrom(buffer, 0, length)).build()
                ).build();
                statusOfFileUpload.onNext(request);
            }
            inputStream.close();
            statusOfFileUpload.onCompleted();
            countDownLatch.await();

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(500);
            response.setDescription("error : " + ex.getMessage());
            return response;
        }
        channel.shutdown();

        return response;
    }

    public ResponseModel<String> getFile() {
        ResponseModel<String> response = new ResponseModel<>();
        response.setStatus(200);
        response.setDescription("ok");
        response.setTimeStamp(LocalDate.now());
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        final String[] path = {"web/"};
        File f = new File(path[0]);
        if (!f.exists()) {
            f.mkdir();
        }
        FileServiceGrpc.FileServiceStub fileServiceStub = FileServiceGrpc.newStub(channel);
        Test.FileWeb.Builder fileWeb = Test.FileWeb.newBuilder();

       fileServiceStub.downloadFiles(Test.FileName.newBuilder().setName("getWeb").build(), new StreamObserver<Test.FileChunk>() {
                    @Override
                    public void onNext(Test.FileChunk fileChunk) {
                        System.out.println("received " + fileChunk.getName());
                        fileWeb.addWeb(fileChunk);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                    }

                    @Override
                    public void onCompleted() {

                        System.out.println("size " + fileWeb.getWebCount());
                        for (int i = 0 ; i< fileWeb.getWebCount();i++){
                            Test.FileChunk fileChunk = fileWeb.getWeb(i);
                            String filePath = path[0] + fileChunk.getName().getName();
                            System.out.println("filePath " + filePath);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                                fileChunk.getFile().writeTo(fileOutputStream);
                                fileOutputStream.close();
                            }catch (Exception ex){
                                    ex.printStackTrace();
                            }
                        }

                    }
                });
        channel.shutdown();

        return response;
    }

    public ResponseModel<String> getTeacher() {
        ResponseModel<String> response = new ResponseModel<>();
        response.setStatus(200);
        response.setDescription("ok");
        response.setTimeStamp(LocalDate.now());
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        try {
            ClassRoomServiceGrpc.ClassRoomServiceStub  classRoomServiceStub= ClassRoomServiceGrpc.newStub(channel);
            StreamObserver<Test.StudentGroup> streamObserver = classRoomServiceStub.joinClass(new StreamObserver<Test.ClassRoom>() {
                @Override
                public void onNext(Test.ClassRoom classRoom) {
                    log.info("class room{}" , classRoom);
                }

                @Override
                public void onError(Throwable throwable) {
                    log.info("error wa nong {}" ,throwable.getMessage());
                }

                @Override
                public void onCompleted() {
                    log.info("onCompleted wa ");

                }
            });
            for (int i = 0 ; i<5;i++){
                Test.StudentGroup.Builder sts = Test.StudentGroup.newBuilder();
                sts.setNumOfGroup(i) ;
                Test.Student t1 =    Test.Student.newBuilder().setName("tar" +i).setGender("male").build();
                Test.Student t2 =   Test.Student.newBuilder().setName("oak" +i).setGender("male").build();
                Test.Student t3 =    Test.Student.newBuilder().setName("film" +i).setGender("male").build();
                Test.Student t4 =   Test.Student.newBuilder().setName("mao" +i).setGender("male").build();
                sts.addStudents(t1);
                sts.addStudents(t2);
                sts.addStudents(t3);
                sts.addStudents(t4);
                streamObserver.onNext(sts.build());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(500);
            response.setDescription("error : " + ex.getMessage());
        }


        channel.shutdown();
        return response;
    }
}
