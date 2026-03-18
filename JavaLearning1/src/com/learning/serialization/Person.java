package com.learning.serialization;

import java.io.Serializable;

public class Person implements Serializable {
    String name;

    Person(){
        System.out.println("person constructor called");
    }
}
