package com.learning.exceptionHandling;

class InvalidAgeException extends RuntimeException{
    //constructor
    public InvalidAgeException(String message){
        super(message);
    }
}
public class CustomUncheckedException {
    static void checkAge(int age) {
        if(age<18){
            throw new InvalidAgeException("Not eligible to vote");
        }
        else{
            System.out.println("Eligible to vote");
        }

    }

    public static void main(String[] args) {
        try{
            checkAge(2);

        }
        catch(InvalidAgeException e){
            System.out.println("exception caught");
            System.out.println(e.getMessage());
        }

    }

}
