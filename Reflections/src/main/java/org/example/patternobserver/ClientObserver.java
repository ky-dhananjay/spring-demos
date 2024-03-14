package org.example.patternobserver;

public class ClientObserver implements Observer{

    @Override
    public void update(String operation, String record) {
        System.out.println("The client says a " + operation + " operation was performed on " + record);
    }
}
