package org.example.functionalInterface;

import java.util.function.Function;

public class ClosuresInJavaDemo {
    public static void main(String[] args) {
        int multiplier = 2;
        Function<Integer, Integer> doublerFunc = x -> x * multiplier;
        System.out.println(doublerFunc.apply(5));
        System.out.println(doublerFunc.apply(6));

    }
}
