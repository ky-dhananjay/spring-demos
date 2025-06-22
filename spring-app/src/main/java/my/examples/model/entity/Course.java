package my.examples.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }
}
