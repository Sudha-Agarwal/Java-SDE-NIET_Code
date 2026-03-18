package com.learning.fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        pw.write("Java Print Writer class");
        pw.flush();
        pw.close();

        PrintWriter pw2 = new PrintWriter(new FileWriter("printData.txt"));
        pw2.write("Print writer data written to file");
        pw2.println("Hello java");
        //formatted
        pw2.printf("name: %s Age: %d", "ABC",25);
        pw2.printf("This is a formatted number: %.2f", 123.456789);
        pw2.flush();
        pw2.close();


    }
}
