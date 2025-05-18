package org.example.oops;

public class OverloadWithIntegerAndObject {
    public static void main(String[] args) {
        demoMethod(1);
        demoMethod(Integer.valueOf("5"));
        demoMethod("hello");
    }
    public static void demoMethod(Object i){
        System.out.println("object parameter method executed");
    }
    public static void demoMethod(Integer i) {
        System.out.println("integer parameter method executed");
    }

}
