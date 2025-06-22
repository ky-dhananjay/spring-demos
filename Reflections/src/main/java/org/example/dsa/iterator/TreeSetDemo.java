package org.example.dsa.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * unique elements only like HashSet
 * access and retrieval times are quiet fast
 * doesn't allow null element
 * maintains sorted(ascending) order
 * insertion order not maintained
 * TreeSet can only allow those generic types that are comparable
 */
public class TreeSetDemo {
    public void iterateTreeSetBookType(){
        Set<Book> set=new TreeSet<>();
        //Creating Books
        // need to override toCompare method
        Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(233,"Operating System","Galvin","Wiley",6);
        Book b3=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b4=new Book(101,"Datas Communications & Networking","Forouzan","Mc Graw Hill",4);

        //Adding Books to TreeSet
        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        //Traversing TreeSet
        System.out.println("tree set size" + set.size());
        for(Book b:set){
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
        }
    }
    public void iterateTreeSetIntType(){

        //Adding Books to TreeSet
        List<Integer> list = new ArrayList<>();
        list.add(2345);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        Set<Integer> set=new TreeSet<>(list);
        //Traversing TreeSet
        for(Integer b:set){
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        TreeSetDemo treeSetDemo = new TreeSetDemo();
        treeSetDemo.iterateTreeSetBookType();
    }
}
