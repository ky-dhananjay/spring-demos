package org.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Employee{
    private String firstName;
    private String lastName;
    private Integer salary;
    private Double weight;

    public Employee(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.salary = builder.salary;
        this.weight = builder.weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Double getWeight() {
        return weight;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private Integer salary;
        private Double weight;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSalary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public Builder setWeight(Double weight) {
            this.weight = weight;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }
    public static Builder builder(){
        return new Builder();
    }

    public static List<Employee> getAllEmployees(){
        return IntStream.range(1,5).mapToObj(i -> Employee.builder()
            .setFirstName("first name" + i)
            .setLastName("last name" + i)
            .setWeight(i * 1.6)
            .setSalary(i * new Random().nextInt(100)).build()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            ", weight=" + weight +
            '}';
    }
}