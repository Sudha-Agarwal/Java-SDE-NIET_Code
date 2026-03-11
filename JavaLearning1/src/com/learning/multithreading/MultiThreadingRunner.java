package com.learning.multithreading;


//Creating a thread by Extending Thread class
class Thread1 extends Thread{
    public void run(){
        System.out.println("Thread1 is in RUNNING state");
        for (int i = 0; i < 100; i++) {
            System.out.print(Thread.currentThread().getName() +  " - " + i + " ");
        }
        System.out.println();
        System.out.println(getName() + " is done");

    }
}

//Creating a thread by implementing Runnable Interface
class Thread2 implements  Runnable{

    @Override
    public void run() {
        System.out.println("Thread2 is in RUNNING state");
        for (int i = 100; i < 200; i++) {
            System.out.print(Thread.currentThread().getName() + " - " + i + " ");
        }
        System.out.println();
        System.out.println(Thread.currentThread().getName() + " is done");

    }
}
public class MultiThreadingRunner {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        System.out.println("before starting a child thread");

        System.out.println("Thread state before start: " + thread1.getState());


        System.out.println("Thread state after start: " + thread1.getState());
        Thread2 thread2 = new Thread2();
        Thread t2 = new Thread(thread2,"thread-2");

        //t2.start();

        //Anonymous inner class with thread name
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName()+ " is in RUNNING state");
                for (int i = 200; i < 300; i++) {
                    System.out.print(Thread.currentThread().getName() + " - " + i + " ");
                }
                System.out.println();
                System.out.println(Thread.currentThread().getName() + " is done");


            }
        },"Thread-3");


        //Lambda expression with thread name
        Thread thread4 = new Thread(()->{
            System.out.println( Thread.currentThread().getName()+ " is in RUNNING state");
            for (int i = 300; i < 400; i++) {
                System.out.print(Thread.currentThread().getName()+ " - " + i + " ");
            }
            System.out.println();
            System.out.println(Thread.currentThread().getName() + " is done");


        },"Thread-4");

        thread1.start();
        t2.start();
        thread3.start();
        thread4.start();


        //System.out.println("child thread completed");
        //System.out.println("main completed");


    }
}
