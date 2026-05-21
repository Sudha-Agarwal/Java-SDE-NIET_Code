package com.learning.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListExample {
    public static void main(String[] args) {
        //create arraylist
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(30);
        //list.add(null);

        list.add(2,50);

        System.out.println(list);
        list.remove(3);
        System.out.println(list.size());

        //iteration:
        /*for (Integer integer : list) {
            if(integer == 10){
                list.remove(integer);
            }
            //System.out.println(integer);
        }*/

        //Iteration using Iterator
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
           int val = it.next();
            if(val==20){
                it.remove();
            }
            //System.out.println(it.next());

        }

        System.out.println(list);
        /*ListIterator<Integer> it1 = list.listIterator(list.size());
        while(it1.hasPrevious()){
            System.out.println(it1.previous());
        }
*/
        //Collections.sort(list);
        //System.out.println("sorted: " + list);

        //list.clear();
        //System.out.println(list);








    }
}
