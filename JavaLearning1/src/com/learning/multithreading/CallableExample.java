package com.learning.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        //simulating a long running task
        System.out.println("Task started by: " + Thread.currentThread().getName());
//will call api and that api will return some data
        int sum = 0;

        for(int i=1; i<=5; i++){
            sum = sum + i;
            Thread.sleep(1000);
        }
        System.out.println("Task completed by: " + Thread.currentThread().getName());
        return sum;
    }
}
public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = new SumTask();
        Future<Integer> future = executor.submit(task);

        System.out.println("Main thread continues working....");

        try{
            //Retrieves the result
            Integer result = future.get();
            System.out.println("result returned by Callbale: " + result);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("main thread working after future get");
        executor.shutdown();

    }
}
