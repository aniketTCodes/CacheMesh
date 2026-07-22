package com.anikettcodes.node;

import com.anikettcodes.cashmesh.proto.*;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver){
        String responseMessage = "Hello "+request.getName();
        GreetingResponse response = GreetingResponse.newBuilder().setResponse(responseMessage).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
