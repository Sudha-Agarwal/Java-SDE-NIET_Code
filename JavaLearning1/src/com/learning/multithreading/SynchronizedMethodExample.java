package com.learning.multithreading;

class SynchronizedSharedResource{
    private int counter = 0;
    private final Object lock = new Object();

    public void incrementCounter(){
        //System.out.println("Thead " + Thread.currentThread().getName() + " incrementing");
        /*try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }*/
        //critical section
        synchronized(lock){
            this.counter++; //not atomic
        }
    }

    public int getCounter(){
        return this.counter;
    }
}
public class SynchronizedMethodExample {
    public static void main(String[] args) {
        SynchronizedSharedResource sharedResource = new SynchronizedSharedResource();

        Thread thread1 = new Thread(()->{
            for(int i=0;i<10000;i++){
                sharedResource.incrementCounter();
            }
        },"thread-1");

        Thread thread2 = new Thread(()->{
            for(int i=0;i<10000;i++){
                sharedResource.incrementCounter();
            }
        },"thread-2");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final counter value " + sharedResource.getCounter());

    }
}

