package com.anikettcodes.cachemesh.cachemesh_node.controller;


import com.anikettcodes.cachemesh.cachemesh_node.service.CacheService;
import com.anikettcodes.proto.*;
import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;
import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class GrpcCacheService extends CacheServiceGrpc.CacheServiceImplBase {

    private final CacheService cacheService;

    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseStreamObserver){

        String key = request.getKey();
        GetResponse.Builder responseBuilder = GetResponse.newBuilder();
        responseBuilder.setStatus(false);
        responseBuilder.setValue(null);
        Optional<byte[]> value = cacheService.get(key);

        if(value.isPresent()){
            responseBuilder.setValue(ByteString.copyFrom(value.get()));
            responseBuilder.setStatus(true);
        }

        responseStreamObserver.onNext(responseBuilder.build());
        responseStreamObserver.onCompleted();

    }


    @Override
    public void put(PutRequest request, StreamObserver<PutResponse> responseObserver){
        cacheService.put(request.getKey(),request.getValue().toByteArray());
        responseObserver.onCompleted();
    }
}
