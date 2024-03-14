package org.example.patterndecorator;

public class Tester {
    public static void main(String[] args) {
        Pizza p = new Olive(new Onion(new ThinCrust()));
        System.out.println(p.getName() +" " +  p.getCost());
    }
}
