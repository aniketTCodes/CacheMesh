package com.anikettcodes.cachemesh.cachemesh_node.service;

import com.anikettcodes.cachemesh.cachemesh_node.cache.Cache;
import com.anikettcodes.cachemesh.cachemesh_node.util.ListNode;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.concurrent.NotThreadSafe;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Primary
@NotThreadSafe
public class LRUCache implements Cache {

    private final int capacity = 10;
    private int size;

    private ListNode head; // Least Recently Used
    private ListNode tail; // Most Recently Used

    private final Map<String, ListNode> nodeMap = new HashMap<>();



    @Override
    public Optional<byte[]> get(String key) {

        ListNode node = nodeMap.get(key);

        if (node == null) {
            return Optional.empty();
        }

        moveToTail(node);

        return Optional.of(node.getValue());
    }

    @Override
    public void put(String key, byte[] value) {

        ListNode node = nodeMap.get(key);

        // Update existing key
        if (node != null) {
            node.setValue(value);
            moveToTail(node);
            return;
        }

        // Evict LRU if full
        if (size == capacity) {
            evictHead();
        }

        ListNode newNode = new ListNode(key, value);

        nodeMap.put(key, newNode);
        appendToTail(newNode);

        size++;
    }

    @Override
    public boolean contains(String key) {
        return nodeMap.containsKey(key);
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public void clear() {
        nodeMap.clear();
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void delete() {

    }

    private void moveToTail(ListNode node) {

        if (node == tail) {
            return;
        }

        // Remove node from current position

        if (node == head) {
            head = head.next;
            head.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Append at tail

        node.prev = tail;
        node.next = null;

        tail.next = node;
        tail = node;
    }

    private void appendToTail(ListNode node) {

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    private void evictHead() {

        if (head == null) {
            return;
        }

        nodeMap.remove(head.getKey());

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

}
