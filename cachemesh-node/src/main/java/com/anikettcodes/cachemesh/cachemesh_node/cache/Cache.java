package com.anikettcodes.cachemesh.cachemesh_node.cache;

import java.util.Optional;

public interface Cache {
    Optional<byte[]> get(String key);
    void put(String key, byte[] value);
    long size();
    boolean contains(String key);
    void clear();
    void delete();
}
