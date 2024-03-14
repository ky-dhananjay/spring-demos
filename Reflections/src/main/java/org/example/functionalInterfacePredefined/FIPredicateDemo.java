package org.example.functionalInterfacePredefined;

import org.example.functionalInterface.Interf;

import java.util.function.Predicate;

/**
 * Comparable(compareTo)
 * Runnable(run)
 * Callable(call)
 * ActionListener(actionPerformed)
 * Comparator
 */
public class FIPredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> i > 10;
        System.out.println(p.test(5));
    }
}
