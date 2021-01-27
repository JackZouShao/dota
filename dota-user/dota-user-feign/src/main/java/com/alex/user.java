package com.alex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class user {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor threadPoolExecutor;
    }
}

// Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        int temp = 0;
        for(;;){

            int val1 = (l1.next == null) ? -1 : l1.val;
            int val2 = (l2.next == null) ? -1 : l2.val;
            if((val1 + val2 + temp) < 0) {
                return null;
            }
            temp = l1.val + l2.val;
            System.out.println(temp * 10);

        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 2;
        for (int i = 8; i > 7 ; i--) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        new Solution().addTwoNumbers(listNode, listNode);
    }
}