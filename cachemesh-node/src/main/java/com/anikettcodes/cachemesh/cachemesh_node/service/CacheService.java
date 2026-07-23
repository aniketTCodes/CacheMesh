package com.anikettcodes.cachemesh.cachemesh_node.service;

import com.anikettcodes.cachemesh.cachemesh_node.cache.Cache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CacheService {
    private final Cache cache;

    public Optional<byte[]> get(String key){
        //TODO Add key validation
        return cache.get(key);
    }

    public void put(String key, byte[] value){
        //TODO Add key validation
        cache.put(key,value);
    }

}
