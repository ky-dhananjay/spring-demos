package org.example.dsa.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public void iterateList(){
        // insertion order maintained, duplicate allowed
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
