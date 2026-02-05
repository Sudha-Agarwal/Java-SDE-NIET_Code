package com.learning.functionalInterfaces;
import java.util.List;

public class StreamRunner {
    public static void main(String[] args) {
        List<String> list = List.of("Sudha","Agarwal", "Agarwala");
        List<String> modified = list.stream()
                .filter((s)->s.startsWith("A"))
                .filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase())
                .toList();
        System.out.println(modified);

        List<Integer> prices = List.of(200,700,1000,400);

        double total = prices.stream()
                .filter(p->p>500)
                .map(p->(int)(p*0.9))
                .reduce(0,Integer::sum);

        System.out.println(total);








    }
}
