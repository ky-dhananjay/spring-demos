package org.example.functionalInterface;

public class Test {
    public static void main(String[] args) {
        Interf i = (a,b) -> a * b;
        System.out.println(i.add(5,3));
    }
}
