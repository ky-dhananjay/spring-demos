package org.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static List<Integer> getListItems(){
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(3);
        l.add(5);
        l.add(6);
        l.add(1);
        l.add(1);
        return l;
    }

    public static Boolean demoAllMatch(List<Integer> l){
        return l.stream().allMatch(i -> {
            // all entries are not tested, breaks out when a condition evaluates to false
            System.out.print(i);
           return i % 2 != 0;
        });
    }
    public static Boolean demoAnyMatch(List<Integer> l){
        return l.stream().anyMatch(i -> {
            // all entries are not tested, breaks out when a condition evaluates to true
            System.out.print(i);
            return i % 2 == 0;
        });
    }

    public static void main(String[] args) {
        List<Integer> l = getListItems();
        System.out.println(demoAnyMatch(l));
    }
}
