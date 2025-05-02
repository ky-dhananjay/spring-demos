package org.example.memoryManagement;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "name='" + name + '\'' +
            '}';
    }

    public void finalize(){
        System.out.println("This object is being gc'd");
    }
}
