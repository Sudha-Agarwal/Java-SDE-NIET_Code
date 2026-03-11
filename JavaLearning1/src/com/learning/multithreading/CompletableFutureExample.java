package com.learning.multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {

        System.out.println("before completable");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            System.out.println("Running in: " + Thread.currentThread().getName());
            return 0;
        });

        System.out.println("after completable");

        int result = future.join();
        System.out.println("Result: " + result);
    }
}
