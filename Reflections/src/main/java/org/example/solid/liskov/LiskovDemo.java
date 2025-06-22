package org.example.solid.liskov;

public class LiskovDemo {
    public static void main(String[] args) {
        Rectangle r = new Square();

        r.setHeight(5);
        r.setWidth(6);

        System.out.println(r.getArea());
    }
}
