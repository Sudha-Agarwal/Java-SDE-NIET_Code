package com.learning.fileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) throws IOException {
        //append: false (default) - overwrites the file
        //append: true - adds to the end of the file

        try(BufferedWriter bw = new BufferedWriter((new FileWriter("output.txt")))){
            bw.write("This is a buffered line");

            bw.newLine();
            bw.flush(); //forces data to be written immediately
            System.out.println("data written successfully");
        }
    }
}
