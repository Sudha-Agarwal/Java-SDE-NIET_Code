package com.learning.collections;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Employee, String>map = new HashMap<>();

        Employee e1 = new Employee(1,"abc");
        Employee e2 = new Employee(2,"xyz");
        Employee e3 = new Employee(2,"xyz");

        map.put(e1,"HR");
        map.put(e2, "IT");
        map.put(e3, "Finance");

        HashMap<Integer, Employee> map2 = new HashMap<>();
        map2.put(1,e1);
        map2.put(2,e2);
        map2.put(3,e3);


        System.out.println(e1);
        for(Integer e: map2.keySet()){
            System.out.println(e + " -> " + map2.get(e));
        }
    }
}
