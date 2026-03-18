package com.learning.serialization;

import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String name;
    int id;
    float salary;
    static String doj = "31-06-25";//takes latest value
    transient String location; //null after deserialization
}

