package org.example.patterndecorator;

public abstract class Pizza {
    private final String name;
    private final Double cost;

    protected Pizza(String name, Double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }
}
