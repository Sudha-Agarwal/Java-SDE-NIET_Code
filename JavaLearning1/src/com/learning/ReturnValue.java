package com.learning;

public class ReturnValue {
    static int divide(int a, int b){
        try{
            int result = a/b;
            return result;

        }
        catch(Exception e){
            return a;

        }
        finally {
            System.out.println("finally still executed");
            return 0;
            //System.out.println("unreachable code ");


        }
    }
    public static void main(String[] args) {
        System.out.println(divide(10,2));

    }
}
