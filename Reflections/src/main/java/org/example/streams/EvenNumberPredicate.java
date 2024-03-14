package org.example.streams;

import java.util.function.Predicate;

public class EvenNumberPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}
