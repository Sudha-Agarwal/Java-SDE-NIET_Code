package com.learning.fileIO;

import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("data.txt");

        int character;

        while((character = reader.read()) != -1){
            System.out.print((char)character);
        }
        reader.close();
    }
}
