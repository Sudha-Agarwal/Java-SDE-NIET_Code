package com.learning.fileIO;

import java.io.File;
import java.io.IOException;

public class FileMetadata {
    public static void main(String[] args) {
        File file = new File("example_folder");

        //creating a directory
        if(!file.exists()){
            file.mkdir();
            System.out.println("Directory created");
        }

        File textFile = new File(file,"test.txt");
        try{
            if(textFile.createNewFile()){
                System.out.println("file created");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("File Name: " + textFile.getName());
        System.out.println("Absolute Path: " + textFile.getAbsolutePath());
        System.out.println("is it a directory?: " + textFile.isDirectory());
        System.out.println("Does it exist?: " + textFile.exists());

    }
}
