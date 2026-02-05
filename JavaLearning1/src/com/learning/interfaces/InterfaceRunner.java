package com.learning.interfaces;

class Person{
    int age;
    String name;
    String addres;

    void speak(){
        System.out.println("Can speak English");
    }

    void calculatSalary(){

    }

    //method overloading
    void sum(int a, int b){
        int res = a+b;
    }

    void sum(String a, String b){
        String res = a.concat(b);
    }

    void  sum(int a){
        int res = a+a;
    }
}

class Animal{
    void makeSound(){

    }
}

class Dog extends Animal{
    @Override
    void makeSound(){

    }
}

class Cat extends Animal{

}


abstract class Accounts{
    int acc_no;
    double balance;
    void deposit(int amount){
        System.out.println("deposit of parent");
    }
   abstract void withdraw(int amount);
}

class SavingAccount extends Accounts{
    int acc_no;
    @Override
    void withdraw(int amount) {
        if(amount > balance){
            System.out.println("Error");
        }
    }
    @Override
    void deposit(int amount){
        System.out.println("deposit of child");
    }
}

class currentAccount extends Accounts{
   @Override
    void withdraw(int amount) {
       if(amount > balance){
           System.out.println("you can withdraw");
           balance-= amount;
       }
    }
}


public class InterfaceRunner {
    public static void main(String[] args) {
        Person obj = new Person();
        obj.name="Sudha";
        obj.age=40;

        obj.speak();











    }
}
