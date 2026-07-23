package com.anikettcodes.cachemesh.cachemesh_node.controller;

import com.anikettcodes.proto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class CacheService extends CacheServiceGrpc.CacheServiceImplBase {
    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseStreamObserver){

    }


    @Override
    public void put(PutRequest request, StreamObserver<PutResponse> responseObserver){

    }
}
