package com.learning.multithreading;

import java.util.concurrent.CompletableFuture;

public class ChainingCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> future =
                CompletableFuture.supplyAsync(()->fetchUser())
                        .thenApply(user -> fetchOrders(user))
                        .thenApply(orders -> calculateBill(orders))
                        .thenAccept((bill -> sendNotification(bill)));

        System.out.println("main thread continues");
        future.join();
    }

    static String fetchUser(){
        //api call to fetch the user data
        sleep();
        System.out.println("user fetched");
        return "User1";
    }

    static int fetchOrders(String user) {
        sleep();
        System.out.println("Orders fetched");
        return 5;
    }
    static double calculateBill(int orders) {
        sleep();
        System.out.println("Bill calculated");
        return orders * 100;
    }

    static void sendNotification(double bill) {
        System.out.println("Notification sent: " + bill);
    }

    static void sleep() {
        try { Thread.sleep(1000); } catch(Exception e) {}
    }
}
