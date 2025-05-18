package org.example.streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamVsStreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().forEach(i -> System.out.println("numbers: " + i));

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        numbers1.parallelStream().forEach(i -> System.out.println("numbers 1: " + i));
        // or
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        numbers2.stream().parallel().forEach(i -> System.out.println("numbers 2: " + i));
    }
}
