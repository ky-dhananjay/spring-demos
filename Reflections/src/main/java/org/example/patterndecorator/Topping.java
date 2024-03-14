package org.example.patterndecorator;

public abstract class Topping extends Pizza{
    private final Pizza pizza;
    protected Topping(String name, Double cost, Pizza pizza) {
        super(name, cost);
        this.pizza = pizza;
    }
    @Override
    public String getName() {
        return super.getName() + pizza.getName();
    }
    @Override
    public Double getCost() {
        return super.getCost() + pizza.getCost();
    }
}
