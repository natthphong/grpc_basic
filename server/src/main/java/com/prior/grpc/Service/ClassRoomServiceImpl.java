package com.prior.grpc.Service;

import com.prior.grpc.proto.ClassRoomServiceGrpc;
import com.prior.grpc.proto.Test;
import io.grpc.stub.StreamObserver;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

public class ClassRoomServiceImpl extends ClassRoomServiceGrpc.ClassRoomServiceImplBase {
   @Override
    public StreamObserver<Test.StudentGroup> joinClass(
            StreamObserver<Test.ClassRoom> responseObserver) {
       return new StreamObserver<>(){
           @Override
           public void onNext(Test.StudentGroup studentGroup) {
               Test.ClassRoom t = Test.ClassRoom.newBuilder().setStudentGroup(studentGroup).setTeacherName("tar").build();
               responseObserver.onNext(t);
           }
           @Override
           public void onError(Throwable throwable) {
               System.out.println("error  " + throwable.getMessage());
           }
           @Override
           public void onCompleted() {
               System.out.println("onCompleted in server");
               responseObserver.onCompleted();
           }
       };
    }
}
