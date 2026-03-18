package com.learning.serialization;

import java.io.Serializable;

public class EmployeeNested implements Serializable {
    String name;
    int id;
    Address address; // nested object

    EmployeeNested(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

}
