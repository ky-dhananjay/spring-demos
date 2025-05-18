package org.example.java8;

import java.util.Optional;

public class DefaultMethodInInterfaceImpl implements DefaultMethodInInterface{
    @Override
    public void abstractMethod() {
        System.out.println("inside implementation class");
    }


}
