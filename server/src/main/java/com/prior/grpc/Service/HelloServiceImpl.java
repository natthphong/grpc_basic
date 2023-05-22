package com.prior.grpc.Service;

import com.prior.grpc.proto.HelloServiceGrpc;
import com.prior.grpc.proto.Test;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(Test.HelloRequest request,
                      StreamObserver<Test.HelloResponse> responseObserver) {

        System.out.println("Hello service running");
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();
        Test.HelloResponse response = Test.HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

}
