package com.demo.student;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private int marks;

}
