package com.learning.exceptionHandling;

public class UncheckedExceptionRunner {
    public static void main(String[] args) {
        int x = 10;

        try{
            //System.out.println(x/0);
            int [] arr = {1,2,3};
            //System.out.println(arr[3]);

            String str = "Hello";
            str = null;
            System.out.println(str.length());
        }
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println("catching exception");
            e.printStackTrace();
        }
        catch(RuntimeException e){
            System.out.println("parent class handler");

        }
        catch(Exception e){

        }



        System.out.println("after exception");

    }
}
