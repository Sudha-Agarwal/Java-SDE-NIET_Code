package com.learning.multithreading;

class Message{
    private String message;
    private boolean hasMessage = false;

    //Method for receiving message (wait here)
    public synchronized void receive(){
        while(!hasMessage){
            try{
                System.out.println("Waiting for message..");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Received " + message);
            hasMessage = false;
        }
    }

    //Method for sending message (notify here)
    public synchronized void send(String msg){
        this.message = msg;
        hasMessage = true;
        System.out.println("Message sent " + msg);
        notify();
    }
    
}
public class WaitNotifyRunner {
    public static void main(String[] args) {
        Message message = new Message();

        //Thread1 - Receiver
        Thread receiver = new Thread(()->{
            message.receive();
        });

        //Thread2 - Sender
        Thread sender = new Thread(()->{
            try{
                Thread.sleep(2000);//delay so receiver waits first
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            message.send("Hello from sender");

        });
        receiver.start();
        sender.start();
    }
}
