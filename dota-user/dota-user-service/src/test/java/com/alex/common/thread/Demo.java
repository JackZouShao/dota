package com.alex.common.thread;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Node;

import java.util.*;

/**
 * @version 1.0.0
 * @className Demo.java
 * @author: yz
 * @date: 2021/11/3 20:45
 */
public class Demo {

    static final Map<Integer, String> space ;

    // 初始化层级关系
    static {
        space = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(" ");
            space.put(i, sb.toString());
        }
    }

    @ToString
    static class Node implements Comparable<Node> {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }


        @Override
        public int compareTo(@NotNull Node node) {

            return node.id == this.id ? 0 : 1;
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(
                new Node(1, 0, "AA"),
                new Node(2, 1, "BB"),
                new Node(3, 1, "CC"),
                new Node(4, 3, "DD"),
                new Node(5, 3, "EE"),
                new Node(6, 2, "FF"),
                new Node(7, 2, "GG"),
                new Node(8, 4, "HH"),
                new Node(9, 5, "II"),
                new Node(10, 0, "JJ"),
                new Node(11, 10, "KK"),
                new Node(12, 10, "LL"),
                new Node(13, 12, "MM"),
                new Node(14, 13, "NN"),
                new Node(15, 14, "OO")
        );
        print(nodeList);
    }

    public static void print(List<Node> nodeList) {

        // write code here
        if(nodeList == null || nodeList.isEmpty()){
            return;
        }

        // 初始化map 按照 <parentId, Set<子节点>> 存储
        Map<Integer, Set<Node>> res = new HashMap<>();
        nodeList.stream().forEach(node ->{
            res.computeIfAbsent(node.parentId, (k) -> new TreeSet<Node>());
            Set<Node> nodes = res.get(node.parentId);
            nodes.add(node);
        });

        // 开始递归循环
        Set<Node> nodeSet = res.get(0);
        p1(nodeSet, res);
    }

    // 计算层级标签 线程不安全,要使用线程安全可以用ThreadLocal
    static int level = 0;

    public static void p1(Set<Node> nodeSet, Map<Integer, Set<Node>> map){
        // 终止递归条件
        if(nodeSet == null){
            return;
        }
        Iterator<Node> iterator = nodeSet.iterator();
        while (iterator.hasNext()){
            Node temp = iterator.next();

            // 根据层级 level 打印
            System.out.println(space.get(level) + temp.name);

            // 进入下层时 层级+1
            level++;
            p1(map.get(temp.id), map);

            // 返回上层时 层级-1
            level--;
        }
    }

}
