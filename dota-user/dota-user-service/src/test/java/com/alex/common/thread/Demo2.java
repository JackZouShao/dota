package com.alex.common.thread;

import lombok.Data;

import java.util.*;

/**
 * @version 1.0.0
 * @className Demo2.java
 * @author: yz
 * @date: 2021/11/3 22:06
 */
public class Demo2 {

    @Data
    static
    class Graph{
        private int [][] edge;
        private Object[] vertex;
    }

    @Data
    static class Pair{
        private final int x;
        private final int y;
    }

    public static List<Map<String,Object>> permutation(Map<String, Object[]> input){
        // write code here
        List<Map<String, Object>> result = new ArrayList<>();

        // 构造领接矩阵
        Graph graph = new Graph();
        int size = input.keySet().size();
        Object [][] arr = new Object[size][];
        graph.edge = new int[input.keySet().size()][];


        int  x=0;
        for (Map.Entry<String, Object[]> entry : input.entrySet()) {
            Object[] value = entry.getValue();
            arr[x] = new Object[value.length];
            for (int k = 0; k < value.length; k++) {
               arr[x][k] = value[k];
            }
            x++;
        }

        //for (int i = 0; i < input.keySet().size(); i++) {
            Stack stack = new Stack();
            stack.push(new Pair(0,0));

            int s = 0;
            while (!stack.isEmpty()){
                Pair peek = (Pair)stack.peek();
                // 遍历当前顶点的下一层结点

                    int length =  arr[peek.x].length;
                    for(; s < length; ){
                        stack.push(new Pair(++s, 0));
                        System.out.println(stack.peek());
                        break;
                    }
                    if(s == length ){
                        s = 0;
                        stack.pop();
                    }
                }



       // }




        for (int i=0;i< arr.length;i++)
            for (int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }






        return null;
    }

    public static void main(String[] args) {
        permutation(Map.of(
                "token", new String[]{"token1", "token2", "token3"},
                "slot-primary", new Integer[]{1, 2, 3, 4, 5},
                "slot-slave", new String[]{"a", "b", "c"}
        )).forEach(System.out::println);
    }

}
