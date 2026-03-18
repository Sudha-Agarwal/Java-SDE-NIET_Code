package com.learning.serialization;

import java.io.*;
public class NestedSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Address addr = new Address("Delhi","India");
        EmployeeNested emp = new EmployeeNested("abc",101,addr);

        //---Serialization----
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.ser"));
        oos.writeObject(emp);
        oos.close();

        System.out.println("Serialized successfully");

        //---Deserialization----
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.ser"));

        EmployeeNested e = (EmployeeNested)ois.readObject();

        System.out.println(e.name);
        System.out.println(e.id);
        System.out.println(e.address.city);
        System.out.println(e.address.state);


    }
}
