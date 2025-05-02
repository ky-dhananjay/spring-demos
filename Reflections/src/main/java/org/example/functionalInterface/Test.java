package org.example.functionalInterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Interf i = (a,b) -> a * b;
        System.out.println(i.add(5,3));

        Predicate<String> strLength = a -> a.length() > 10;
        BiPredicate<Integer, Integer> twoNumberSumEvenOdd = (a, b) -> (a + b) % 2 == 0;

        Function<Integer, Integer> func = a -> a * a;
        BiFunction<Integer,Integer,Integer> twoNumberSum = Integer::sum;

        Consumer<Integer> printNumber = System.out::println;
        BiConsumer<Integer,Integer> twoNumberConsumer = (a,b) -> System.out.println(a + b);

        Supplier<IntStream> supplier = () -> IntStream.range(1,10).filter(num -> num % 2 == 0);
        IntStream evenStream = supplier.get();
        evenStream.forEach(System.out::println);


    }
}
