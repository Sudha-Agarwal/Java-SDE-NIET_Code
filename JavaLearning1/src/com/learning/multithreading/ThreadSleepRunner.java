package com.learning.multithreading;

public class ThreadSleepRunner implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello");
        try{
            System.out.println("child thread will sleep");
            Thread.sleep(4000);//pauses running thread for 2 sec.

        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("child thread finished");
        System.out.println(Thread.currentThread().getName());
    }

    void m1(){
        System.out.println("m1 method");
    }

    public static void main(String[] args) {
        ThreadSleepRunner thread = new ThreadSleepRunner();
        Thread t = new Thread(thread);

        t.start();
        System.out.println("Number of active threads: " + Thread.activeCount());
        thread.m1();
        System.out.println("main thread running");
    }

}
