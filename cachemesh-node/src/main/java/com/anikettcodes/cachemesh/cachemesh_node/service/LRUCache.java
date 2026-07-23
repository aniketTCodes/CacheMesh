package com.anikettcodes.cachemesh.cachemesh_node.service;

import com.anikettcodes.cachemesh.cachemesh_node.cache.Cache;
import org.springframework.stereotype.Service;
import javax.annotation.concurrent.ThreadSafe;
import java.util.Optional;

@Service
@ThreadSafe
public class LRUCache implements Cache {
    @Override
    public Optional<byte[]> get(String key) {
        return Optional.empty();
    }

    @Override
    public void put(String key, byte[] value) {

    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void delete() {

    }
}
