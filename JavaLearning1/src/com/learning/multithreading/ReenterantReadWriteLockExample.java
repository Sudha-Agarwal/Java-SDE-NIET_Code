package com.learning.multithreading;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource1{
    private int data = 0;

    //Create read-write lock
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void readData(){
        //Acquire read lock
        rwLock.readLock().lock();

        try{
            System.out.println(Thread.currentThread().getName() + " is reading data: " + data);
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            //Always release lock
            rwLock.readLock().unlock();
        }

    }

    public void writedata(int newData){
        //Acquire write lock
        rwLock.writeLock().lock();

        try{
            System.out.println(Thread.currentThread().getName() + " is writing data: " + newData);
            Thread.sleep(1000);
            data = newData;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            rwLock.writeLock().unlock();
        }
    }
}
public class ReenterantReadWriteLockExample {
    public static void main(String[] args) {
        SharedResource1 resource = new SharedResource1();

        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(()-> resource.writedata(10)).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start(); new Thread(resource::readData).start();
        new Thread(resource::readData).start();

    }
}
