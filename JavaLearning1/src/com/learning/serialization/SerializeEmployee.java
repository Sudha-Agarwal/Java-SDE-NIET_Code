package com.learning.serialization;

import java.io.*;

public class SerializeEmployee {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee emp = new Employee();
        emp.name="abc";
        emp.id = 12345;
        emp.salary = 35000.00f;
        //emp.doj = "30-07-2025";
        emp.location = "Delhi";

        Employee emp1 = new Employee();
        emp1.name="abc";
        emp1.id = 12345;
        emp1.salary = 35000.00f;
        //emp1.doj = "30-07-2025";
        emp1.location = "Delhi";

       Employee [] emps = {emp1,emp};

        //create an object of FileOutStream class to connect to objfile.txt file
        FileOutputStream fos = new FileOutputStream("objfile.ser");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //call writeObject() of ObjectOutputStream class
        oos.writeObject(emps);
        oos.flush();
        oos.close();
        fos.close();
        System.out.println("serialization is done");
        emp1.doj = "30-07-25";

        //---Deserialization --------
        System.out.println("-----Deserialization-----");

        FileInputStream fis = new FileInputStream("objfile.ser");
        ObjectInput ois = new ObjectInputStream(fis);

        //Object obj = ois.readObject(); //reading objects
        Employee[] employees = (Employee[])ois.readObject(); //casting back
        ois.close();
        fis.close();

        for(Employee e: employees){
            System.out.println("Name: " + e.name);
            System.out.println("Employee id: " +e.id);
            System.out.println("Employee's salary: "+ "Rs " +e.salary);
            System.out.println("Date of joining: " +e.doj);
            System.out.println("Location: " +e.location);

        }



    }
}
