package org.example.collections;

import java.util.Objects;

public class Student {
    private String id;
    private String firstName;
    private String lastName;

    public Student() {
    }

    public Student(String id, String firstName, String lastName) {
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

    public Student setId(String id) {
        this.id = id;
        return this;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
        return this.getId().equals(other.getId())
            && this.getFirstName().equals(other.getFirstName())
            && this.getLastName().equals(other.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId() + this.getFirstName() + this.getLastName());
    }
}
