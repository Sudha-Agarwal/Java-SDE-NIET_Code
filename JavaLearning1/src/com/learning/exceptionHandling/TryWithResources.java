package com.learning.exceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources
    {
        public static void main(String[] args)  {
        //FileReader fr = null;
            //Try-with-resources (Java7)
        try( FileReader fr = new FileReader("myfile.txt");
             BufferedReader br = new BufferedReader(fr)
        ){
            //int x = 10/0;

            System.out.println("file opened");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            System.out.println("file not found");
        }
        /*finally {
            System.out.println("always executed");

            if(fr!=null){
                try{
                    fr.close();
                    System.out.println("file closed");
                }
                catch(IOException e){
                    System.out.println("error while closing the file");
                }

            }
        }*/

        System.out.println("after try catch");

    }
    }

