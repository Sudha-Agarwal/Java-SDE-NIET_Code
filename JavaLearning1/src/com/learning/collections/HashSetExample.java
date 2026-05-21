package com.learning.collections;

import java.util.HashSet;
import java.util.Objects;

class Employee{
    int id;
    String name;
    String dept;

    public Employee(int id, String name, String dept){
        this.id = id;
        this.name = name;
        this.dept = dept;
    }
    @Override
    public int hashCode(){
        System.out.println("hashcode called");
        System.out.println(Objects.hash(id,name));
        return Objects.hash(id,name);
    }

    @Override
    public boolean equals(Object obj){
        System.out.println("equals called");
        if(this == obj) return true;
        Employee emp = (Employee)obj;
        return id == emp.id && Objects.equals(name,emp.name);
    }

    @Override
    public String toString(){
        return id + " - " + name;
    }

}


public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);

        Employee e1 = new Employee(1,"abc");
        Employee e2 = new Employee(2,"xyz");
        Employee e3 = new Employee(2,"xyz");

        HashSet<Employee> emplSet = new HashSet<>();
        emplSet.add(e1);
        emplSet.add(e2);
        emplSet.add(e3);

        for(Employee e : emplSet){
            System.out.println(e.id);
        }
        //System.out.println(emplSet);
        System.out.println(set);
    }
}
