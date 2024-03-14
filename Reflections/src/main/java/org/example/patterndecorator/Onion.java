package org.example.patterndecorator;

public class Onion extends Topping{
    protected Onion(Pizza pizza) {
        super("Onion", 5.0, pizza);
    }
}
