package org.example.dsa.treeMapAndTreeSet;

import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class TreeMapDemo {
    public static List<String> generateStrings(int size){
        return IntStream.range(0,size)
            .mapToObj(i -> String.valueOf(i * new Random().nextFloat()))
            .toList();
    }

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();

    }

}
