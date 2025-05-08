package org.example.collections;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setId(String id) {
        this.id = id;
        return this;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        Employee other = (Employee) obj;
        return this.getId().equals(other.getId())
            && this.getFirstName().equals(other.getFirstName())
            && this.getLastName().equals(other.getLastName());
    }
}
