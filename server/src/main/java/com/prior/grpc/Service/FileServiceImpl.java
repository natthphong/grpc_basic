package com.prior.grpc.Service;

import com.google.protobuf.ByteString;
import com.prior.grpc.proto.FileServiceGrpc;
import com.prior.grpc.proto.Test;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.io.*;
import java.nio.file.Files;




public class FileServiceImpl extends FileServiceGrpc.FileServiceImplBase {

    @Override
    public StreamObserver<Test.FileChunk> uploadFiles(
            StreamObserver<Test.UploadStatus> responseObserver) {
        final String[] path = {"files/"};
        File f = new File(path[0]);
        if (!f.exists()) {
            f.mkdir();
        }
        final String[] filePath = new String[1];

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.out.println("Upload File ");
        return  new StreamObserver<>() {
            @Override
            public void onNext(Test.FileChunk fileChunk) {
                 filePath[0] = path[0] +fileChunk.getName().getName();
                System.out.println("received " + fileChunk.getFile().getContent().size());
                try {
                    fileChunk.getFile().getContent().writeTo(outputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                    responseObserver.onError(Status.INTERNAL.withDescription("Error wa nong").asRuntimeException());
                }
            }
            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error wa nong ");
            }
            @Override
            public void onCompleted() {
                try {
                    FileOutputStream fis = new FileOutputStream(filePath[0]);
                    outputStream.writeTo(fis);
                    outputStream.close();
                    fis.close();
                }catch (Exception ex){
                    responseObserver.onError(Status.INTERNAL.withDescription("write file error wa nong").asRuntimeException());
                }
                responseObserver.onNext(Test.UploadStatus.newBuilder().setMessage("upload file success").build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void downloadFiles(Test.FileName request,
                              io.grpc.stub.StreamObserver<Test.FileChunk> responseObserver)  {
        System.out.println("request " + request.getName());
        File html = new File("web/test.html");
        File css = new File("web/test.css");
        File js = new File("web/test.js");
        File []files = new File[3];
        files[0] = html ;
        files[1] = css;
        files[2] = js;

        try {
            for (File file : files){

                byte[] fileData = Files.readAllBytes(file.toPath());
                    Test.FileChunk web = Test.FileChunk.newBuilder().setName(
                                Test.FileName.newBuilder().setName(file.getName()).build()
                    ).setFile(
                            Test.File.newBuilder().setContent(ByteString.copyFrom(fileData)).build()
                    ).build();
                responseObserver.onNext(web);
            }

            responseObserver.onCompleted();

        }catch (Exception ex){
            ex.printStackTrace();

        }

    }
}
