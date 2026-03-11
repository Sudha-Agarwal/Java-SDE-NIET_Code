package com.learning.multithreading;

// Shared resource class
class SharedResource {

    // Shared data
    private int data = 0;

    // Flag to check if writing is happening
    private boolean isWriteInProgress = false;

    // -------------------- READ METHOD --------------------
    public synchronized void readData()  {

        // If a write operation is in progress,
        // reader should wait until writing is finished
        while (isWriteInProgress) {
            try {
                System.out.println(Thread.currentThread().getName()
                        + " waiting because write is in progress...");

                // Releases the monitor lock and goes to WAITING state
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try{
            Thread.sleep(1000);

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        // If no writing is happening, read the data
        System.out.println(Thread.currentThread().getName()
                + " is reading data: " + data);


    }

    // -------------------- WRITE METHOD --------------------
    public synchronized void writeData(int newData) {

        // Indicate that writing has started
        isWriteInProgress = true;

        System.out.println(Thread.currentThread().getName()
                + " is writing data: " + newData);

        try {
            // Simulate time taken to write data
            Thread.sleep(1000);

            System.out.println("Write completed, updating value...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Update the shared data
        data = newData;

        // Writing finished
        isWriteInProgress = false;

        // Wake up all waiting reader threads
        notifyAll();
    }
}

// -------------------- MAIN CLASS --------------------
public class ReadWriteParallelExample {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        // -------------------- MULTIPLE READERS --------------------
        /*Thread[] readerThreads = new Thread[5];

        for (int i = 0; i < 5; i++) {

            readerThreads[i] = new Thread(() -> {
                resource.readData();
            });

            readerThreads[i].start();
        }

        // -------------------- ONE WRITER --------------------
        Thread writeThread = new Thread(() -> {
            resource.writeData(10);
        });

        writeThread.start();
    */
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(() -> resource.writeData(10)).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
        new Thread(resource::readData).start();
    }
}