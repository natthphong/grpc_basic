package com.prior.grpc.server;

import com.prior.grpc.Service.ClassRoomServiceImpl;
import com.prior.grpc.Service.FileServiceImpl;
import com.prior.grpc.Service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {


    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder
                .forPort(8081)
                .addService(new HelloServiceImpl())
                .addService(new FileServiceImpl())
                .addService(new ClassRoomServiceImpl())
                .build();
        System.out.println("grpc server running in 8081");
        server.start();
        server.awaitTermination();

    }

}
