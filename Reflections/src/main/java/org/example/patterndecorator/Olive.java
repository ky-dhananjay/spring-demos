package org.example.patterndecorator;

public class Olive extends Topping{

    protected Olive(Pizza pizza) {
        super("Olive", 5.0, pizza);
    }
}
