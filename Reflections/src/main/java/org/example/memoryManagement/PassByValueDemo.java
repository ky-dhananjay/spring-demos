package org.example.memoryManagement;

public class PassByValueDemo {
    /**
     * Java is always pass by value
     * @param args
     */
    public static void main(String[] args) {
        Customer customer = new Customer("customer1");
        System.out.println("original main: " + customer);
        m1(customer);
        System.out.println("after m1: " + customer);
    }

    public static void m1(Customer c){
        System.out.println("original m1: " + c);
        // this assignment doesn't changes the original customer object reference
        c = new Customer("customer2");
        System.out.println("assigned new m1: "+ c);
    }
}
