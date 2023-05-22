package com.prior.grpc;

import com.prior.grpc.Service.HelloServiceImpl;
import com.prior.grpc.server.GrpcServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(GrpcApplication.class, args);
		GrpcServer.main(new String[0]);
	}

}
