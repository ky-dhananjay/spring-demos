package org.example.streams;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class ReduceDemo {
    public static void main(String[] args) {
        // findMax()
        // findSum();
        findAverage();
    }
    public static void findMax(){
        List<Integer> l = List.of(10,12,23,4,5);
        Optional<Integer> maxOptional = l.stream()
            .reduce((a,b) -> a > b ? a : b);
        maxOptional.ifPresent(System.out::println);

        Integer[] arr = new Integer[0];
    }
    public static void findSum(){
        List<Integer> l = List.of(10,12,23,4,5);
        int maxOptional = l.stream()
            .reduce(-10, (a,b) -> a + b);
        System.out.println(maxOptional);
    }
    public static void findAverage(){
        List<Integer> l = List.of(10,12,23,4,5);
        // convert list to varargs
        Integer [] arr = l.toArray(new Integer[0]);
        OptionalDouble maxOptional = l
            .stream()
            .mapToInt(i -> i)
            .average();
        System.out.println(maxOptional.getAsDouble());
    }
}
