package com.learning.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=1; i<=10; i++){
            int taskNumber = i;

            executor.submit(()->{
                System.out.println("Task " + taskNumber + " executed by " +
                        Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){

                }
            });
        }
        executor.shutdown();

    }
}
