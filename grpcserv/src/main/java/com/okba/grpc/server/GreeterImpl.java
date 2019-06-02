package com.okba.grpc.server;

import com.proto.helloworld.GreeterGrpc;
import com.proto.helloworld.HelloReply;
import com.proto.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String string = request.getName();
        String result = "hellooooowwww  " + string;
        HelloReply reply = HelloReply.newBuilder()
                .setMessage(result)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
