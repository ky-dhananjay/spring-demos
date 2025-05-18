package org.example.java8;

public class DefaultMethodIninterfaceDemo {
    public static void main(String[] args) {
        DefaultMethodInInterface defaultMethodInInterface = new DefaultMethodInInterfaceImpl();
        defaultMethodInInterface.defaultMethod();

        DefaultMethodInInterface.staticMethod();
    }
}
