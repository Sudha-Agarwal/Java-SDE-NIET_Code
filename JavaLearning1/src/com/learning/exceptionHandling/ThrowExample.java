package com.learning.exceptionHandling;

public class ThrowExample {
    static void checkAge(int age){
        if(age<18){
            throw new ArithmeticException("Not eligible to vote");
        }
        System.out.println("Eligible to vote");
    }

    public static void main(String[] args) {
        try{
            checkAge(20);
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }

    }

}
