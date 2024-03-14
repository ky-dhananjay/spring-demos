package com.example.demo.model.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
}
