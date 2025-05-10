package org.example.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionPractice {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        for(int i = 0; i < 3; i++){
            l.add(l.get(i) + i);
        }
        System.out.println(l);
    }
}
