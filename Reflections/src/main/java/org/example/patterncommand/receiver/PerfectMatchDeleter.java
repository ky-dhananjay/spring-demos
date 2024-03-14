package org.example.patterncommand.receiver;

import org.example.patterncommand.data.Store;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {

    public void delete(String name){
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach((tag) -> tags.add(tag));
        for (String tag : tags){
            if(tag.equals(name)){
                Store.deleteTag(name);
            }
        }
    }
}
