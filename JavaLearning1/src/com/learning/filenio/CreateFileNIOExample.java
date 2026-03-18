package com.learning.filenio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileNIOExample {
    public static void main(String[] args) {
        try{
            Path path = Paths.get("datanio.txt");
            //Files.createFile(path);
            //System.out.println("File created successfully");

            String content = "Hello Java NIO";

            Files.write(path, content.getBytes());
            System.out.println("Data written successfully");

            String ReadContent = new String(Files.readAllBytes(path));
            System.out.println(ReadContent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
