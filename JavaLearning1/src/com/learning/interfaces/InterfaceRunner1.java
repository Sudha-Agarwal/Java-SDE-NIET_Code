package com.learning.interfaces;


interface Moveable{
    int move(int a);

    void move();
    int X = 10;
}
interface Moveable1{
    void move();
    void move1();
    int X = 10;

}
class Dog1 implements Moveable, Moveable1{
    @Override
    public int move(int a) {
        return 10;
    }

    @Override
    public void move1() {

    }

    @Override
    public void move() {

    }
}
public class InterfaceRunner1 {
    public static void main(String[] args) {
        Moveable obj = new Dog1();
        obj.move(10);

        int x = 10;
    }
}
