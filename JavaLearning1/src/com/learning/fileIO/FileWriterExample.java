package com.learning.fileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("data1.txt",true);

        writer.write("Hello Java\n");
        writer.write("This is FileWriter example appended");

        writer.close();

        System.out.println("Data written successfully.");
        writer.close();
    }

}
