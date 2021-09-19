package com.example.student.Student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.Entity;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private Long id;
    private String name ;
    private String email;

    private Integer age;

    private LocalDate dob;
}
