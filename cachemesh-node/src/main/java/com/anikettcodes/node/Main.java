package com.anikettcodes.node;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {

    public static  void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder
                .forPort(50051)
                .addService(new GreetingServiceImpl())
                .build();

        server.start();
        System.out.println("Server started");
        System.out.println("Listening on port : "+50051);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Server stopped");
        }));

        server.awaitTermination();

    }
}
