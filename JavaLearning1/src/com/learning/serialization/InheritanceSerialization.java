package com.learning.serialization;

import java.io.*;

public class InheritanceSerialization {
    public static void main(String[] args) {
        try{
            Student std = new Student("abc",101);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));

            oos.writeObject(std);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("student.ser"));

            Student s = (Student) ois.readObject();
            ois.close();


            System.out.println("Name: " + s.name);
            System.out.println("roll no: " + s.rollNo );

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
