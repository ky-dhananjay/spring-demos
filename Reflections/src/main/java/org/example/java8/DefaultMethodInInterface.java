package org.example.java8;

public interface DefaultMethodInInterface {
    void abstractMethod();

    default void defaultMethod() {
        System.out.println("Inside defaultMethod.");
        this.abstractMethod(); // Calling the abstract method
        this.anotherDefaultMethod(); // Calling another default method
    }

    default void anotherDefaultMethod() {
        System.out.println("Inside anotherDefaultMethod.");
    }

    static void staticMethod(){
        System.out.println("inside static method");
        // here this cannot be used because this is being tried to be used from
        // a static context.
    }
}
