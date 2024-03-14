package org.example.patterncommand.data;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static List<String> tags = new ArrayList<>() {
        {
            add("maths");
            add("mathematics");
            add("math");
            add("greedy");
            add("stackoverflow");
        }
    };

    public static List<String> getTags() {
        return tags;
    }
    public static void insertTag(String name){
        if(tags == null){
            tags = new ArrayList<>();
        }
        System.out.println("inserted tag: " + name);
        tags.add(name);
    }
    public static void deleteTag(String name){
        System.out.println("deleted tag: " + name);
        tags.remove(name);
    }

}
