package com.alex.common;


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

        ListNode res;
        ListNode cursor = res = new ListNode();
        int carry = 0;
        for(;;){

            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            carry = val1 + val2 + carry;
            cursor.next = new ListNode(carry % 10);
            cursor = cursor.next;
            carry = carry / 10;
            if(carry !=0 ) cursor.next = new ListNode(carry);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            if(l1 == null && l2 ==null){
                break;
            }
        }
        return res.next;
    }

    public int lengthOfLongestSubstring(String s) {

        char[] array = s.toCharArray();
        int length = array.length;
        int res = 0;
        int index = 0;
        loopA:
        for (int i = 0; i < length ; i++) {
            for (int j = 1; j < length; j++) {
                if (array[j] != array[i]) {
                    res++;
                    continue  ;
                }
                if (res > index) {
                    index = res;
                }
                res = 0;
                break loopA;
            }
        }
        return index + 1;
    }


    public void test(){
        int length = lengthOfLongestSubstring("pewwpew");
        System.out.println(length);
    }

    public static void main(String[] args) {
        new Solution().test();



//        ListNode listNode = new ListNode();
//        ListNode cursor = listNode;
//        listNode.val = 2;
//        for (int i = 8; i > 4 ; i--) {
//            cursor.next = new ListNode(i);
//            cursor = cursor.next;
//        }
//        ListNode listNode1 = new ListNode(5);
//
//       ListNode res = new Solution().addTwoNumbers(listNode, listNode);
    }
}
class Main {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            System.out.println("i = " + i);
            for (int j=i+1; j<=10; j++) {
                System.out.println("j = " + j);
                if (j >= i) {
                    break;
                }
            }
            // break跳到这里
            System.out.println("breaked");
        }
    }
}
