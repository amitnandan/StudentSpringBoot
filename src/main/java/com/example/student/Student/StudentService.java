package com.example.student.Student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @GetMapping
    public List<Student> getStudent()
    {
        return List.of( new Student(1L,"AMIT" , "a.amitnandan@gmail.com" ,
                        52,
                        LocalDate.of(1999,1,21)
                )
        );
    }
}
