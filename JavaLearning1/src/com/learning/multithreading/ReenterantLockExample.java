package com.learning.multithreading;


import java.util.concurrent.locks.ReentrantLock;

class Counter{
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock(); //acquire the lock
        try{
            for(int i = 0; i<10000; i++){
                count++;
            }
        }
        finally {
            lock.unlock(); //release
        }
    }

    public int getCount(){
        return this.count;
    }
}
public class ReenterantLockExample {
    public static void main(String[] args)  throws InterruptedException{
        Counter counter = new Counter();

        Thread t1 = new Thread(()->{
            counter.increment();
        });
        Thread t2 = new Thread(()->{
            counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount());

    }
}
