package com.okba.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class HelloworldServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server grpc Started....");
        Server server = ServerBuilder.forPort(9090)
                .addService(new GreeterImpl())
                .build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));
        server.awaitTermination();
    }
}
