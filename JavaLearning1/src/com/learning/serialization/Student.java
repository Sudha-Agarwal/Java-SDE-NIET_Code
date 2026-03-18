package com.learning.serialization;

import java.io.Serializable;

public class Student extends Person {
    int rollNo;

    Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

}
