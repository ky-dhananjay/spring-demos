package org.example.springapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "birth_date")
    private Date birthDate;

    public Person() {
    }

    public Person(Date birthDate, int id, String location, String name) {
        this.birthDate = birthDate;
        this.id = id;
        this.location = location;
        this.name = name;
    }

    public Person(Date birthDate,String location, String name) {
        this.birthDate = birthDate;
        this.location = location;
        this.name = name;
    }

}
