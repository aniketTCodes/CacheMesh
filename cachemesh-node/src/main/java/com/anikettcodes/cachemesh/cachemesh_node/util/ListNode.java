package com.anikettcodes.cachemesh.cachemesh_node.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
public class ListNode {
    private final String key;

    @Setter
    private byte[] value;

    public ListNode next;

    public ListNode prev;

    public ListNode(String key, byte[] value){
        this.key = key;
        this.value = value;
    }

}
