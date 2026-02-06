package com.learning.exceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

class Parent{
    void display() throws IOException {

    }
}

class Child extends Parent{
    void display()  throws FileNotFoundException {

    }

}
public class OverridingSubClassDemo {
}
