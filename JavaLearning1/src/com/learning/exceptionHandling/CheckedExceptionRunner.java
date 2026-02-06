package com.learning.exceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionRunner {

    static void readFile() throws FileNotFoundException{

           File file = new File("myfile.txt");
            FileReader fr = new FileReader(file);
    }
    public static void main(String[] args){
        try{
            File file = new File("myfile.txt");
            FileReader fr = new FileReader(file);
            System.out.println("File opened");

        }
        catch(FileNotFoundException | NullPointerException  e){
            System.out.println("File not found");
        }

        try{
            readFile();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }

    }
}
