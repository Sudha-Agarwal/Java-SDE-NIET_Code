package com.learning.interfaces;

abstract class Accounts1{
    int acc_no;
    double balance = 100;
    void deposit(int amount){
        System.out.println("deposit of parent");
    }
     abstract void withdraw(int amount);
    void print(){
        System.out.println("print of parent");
    }
}
class SavingAccount1 extends Accounts1{
    int acc_no;
    @Override
    void withdraw(int amount) {
        System.out.println("withdraw of child - savings");
        if(amount > balance){
            System.out.println("Error");
        }
    }
    @Override
    void deposit(int amount){
        System.out.println("deposit of child");
    }
}
class currentAccount1 extends Accounts1{
    @Override
    void withdraw(int amount) {
        System.out.println("withdraw of child - current");
        if(amount > balance){
            System.out.println("you can withdraw");
            balance-= amount;
        }
    }
    void print1(){
        System.out.println("print of current");
    }
}
public class AbstractClassRunner {
    public static void main(String[] args) {
        Accounts1 obj = new currentAccount1();

        obj.withdraw(10);
        obj.deposit(20);
        ((currentAccount1) obj).print1();

        Accounts1 obj2 = new SavingAccount1();

        int x = 10;
        Accounts obj1 = new currentAccount();
        int arr[] = new int[2];

    }




    static int sum(int num1, int num2){
        System.out.println("adding");
        return num1+num2;
    }

    int result = sum(2,3);
}
