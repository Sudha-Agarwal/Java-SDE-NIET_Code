package com.learning.filenio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsyncReadExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("datanio.txt");

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        Future<Integer> result = channel.read(buffer,0);

        while (!result.isDone()){
            System.out.println("Reading file");
        }

        buffer.flip();

        while(buffer.hasRemaining()){
            System.out.println((char)buffer.get());
        }
        channel.close();


    }

}
