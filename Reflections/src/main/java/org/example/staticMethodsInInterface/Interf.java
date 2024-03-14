package org.example.staticMethodsInInterface;

public interface Interf {
    public static void main(String[] args) {
        System.out.println("this is main method in interface woohoho!!!");
        Test t = new Test();
        t.m1();
    }
}
