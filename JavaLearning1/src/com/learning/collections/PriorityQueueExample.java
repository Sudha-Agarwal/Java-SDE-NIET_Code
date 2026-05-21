package com.learning.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>() ;
        pq.add(20);
        pq.add(10);
        pq.add(30);
        pq.add(67);
        pq.add(2);
        pq.add(34);
        pq.add(27);

        System.out.println(pq.poll());
        System.out.println(pq);

        System.out.println(pq.poll());
        System.out.println(pq);

    }
}
