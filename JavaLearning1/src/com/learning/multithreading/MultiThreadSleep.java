package com.learning.multithreading;

public class MultiThreadSleep implements Runnable{
    public void run(){
        for(int i=1; i<=3; i++){
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " I: "  +i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MultiThreadSleep(),"thread-1");
        Thread thread2 = new Thread(new MultiThreadSleep(),"thread-2");

        thread1.start();
        thread2.start();

        System.out.println("main finished");


    }
}
