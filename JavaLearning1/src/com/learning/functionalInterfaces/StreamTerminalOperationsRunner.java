package com.learning.functionalInterfaces;

import java.util.Arrays;
import java.util.List;

public class StreamTerminalOperationsRunner {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5,6,8,1,9,4);

        //forEach
        //nums.stream().forEach(x->System.out.println(x));
        //nums.stream().forEach(System.out::println);

        //count
        long count = nums.stream().count();
        System.out.println(count);

        //min
        int min = nums.stream().min(Integer::compareTo).get();
        System.out.println(min);

        //anyMatch
        boolean anyMatch = nums.stream().anyMatch(x->x>10);
        System.out.println(anyMatch);

    }

}
