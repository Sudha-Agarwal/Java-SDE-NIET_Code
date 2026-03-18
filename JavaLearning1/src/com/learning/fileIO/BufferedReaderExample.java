package com.learning.fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("data1.txt"))){
            String line;

            while((line = br.readLine()) != null){
                System.out.println("Line: " + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
