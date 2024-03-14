package org.example.reflections;

import org.example.annotations.JsonElement;
import org.example.annotations.JsonSerialized;

@JsonSerialized
public class Person extends Animal {
    @JsonElement
    private String age;
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;

    public String profession;

    public Person(String age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
