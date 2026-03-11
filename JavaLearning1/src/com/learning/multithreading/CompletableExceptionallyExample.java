package com.learning.multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableExceptionallyExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            int result = 10/0;
            return result;
        }).exceptionally(ex->{
            System.out.println("error occurred: " + ex);
            return 0; //fallback value
        });

        System.out.println("Result: " + future.join());
    }
}
