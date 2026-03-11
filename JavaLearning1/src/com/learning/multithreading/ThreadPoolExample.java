package com.learning.multithreading;

import java.util.concurrent.ExecutorService;
// Import Executors class which provides factory methods to create thread pools
import java.util.concurrent.Executors;

class Task implements Runnable{
    private int taskNumber;

    public Task(int taskNumber){
        this.taskNumber = taskNumber;
    }
    @Override
    public void run() {
        System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of 3 threads
        // Only 3 threads will run tasks at the same time
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=1; i<=10; i++){
            Task task = new Task(i);

            // Submit the task to the thread pool
            // The thread pool will assign an available thread to execute it
            executor.submit(task);
        }
        System.out.println("main thread continues..");
        // Shutdown the thread pool
        // After shutdown(), no new tasks can be submitted
        executor.shutdown();

        System.out.println("all task submitted");
    }



}
