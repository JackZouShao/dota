package com.alex.gateway;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class DotaGatewayApplicationTests {

//    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        Deque deque = new LinkedList();
        deque.add(null);
        deque.push(null);
        deque.poll();
        System.out.println(deque.size());
        Stack stack = new Stack();

    }
}
