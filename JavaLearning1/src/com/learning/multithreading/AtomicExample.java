package com.learning.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class Counter2{
    AtomicInteger count = new AtomicInteger();
    public void increment(){
        count.incrementAndGet();
    }

}
public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();

        Thread t1 = new Thread(()->{
            for(int i=0; i<10000; i++){
                counter.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0; i<10000; i++){
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);


    }
}
