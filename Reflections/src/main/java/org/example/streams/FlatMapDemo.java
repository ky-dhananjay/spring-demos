package org.example.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {

        // given list of list of string, find string whose length is greater than 4 and starts with s

        List<List<String>> list = new ArrayList<>();
        List<String> l1 = List.of("ndfbaedkf", "jdfnmdtgkrt", "sgnfbrftn");
        List<String> l2 = List.of("ndfbaedkf", "sdfnmdtgkrt", "sgnfbrftn");
        list.add(l1);
        list.add(l2);

        List<String> strStartingWithSAndLengthGrtThan4 =
            list.stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.length() > 4 && s.startsWith("s"))
                .toList();
        System.out.println(strStartingWithSAndLengthGrtThan4);
    }
}
