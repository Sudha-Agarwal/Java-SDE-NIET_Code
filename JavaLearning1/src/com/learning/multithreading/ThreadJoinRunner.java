package com.learning.multithreading;

public class ThreadJoinRunner implements Runnable{
    @Override
    public void run() {
        System.out.println("Child thread is running");
        for(int i = 1; i <= 4; i++){
            System.out.println("I: " +i);
            try
            {
                Thread.sleep(2000); // Pauses the execution of child thread for 2 sec.
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Child thread is ending");

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadJoinRunner());
        thread.start();

        try{
            thread.join(1000);//wait for thread to end till 1 sec
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread is ending");

    }


}
