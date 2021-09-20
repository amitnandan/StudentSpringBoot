package com.example.student.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner( StudentRepository studentRepository)
    {
        return  args -> {

                Student stud1 = new Student(

                                "Amit",
                                "a.amitnandan@gmail.com",
                    LocalDate.of(1999,1,21)
                        );
                Student stud2 = new Student(
                    "Rahul",
                    "r.rahulraj@gmail.com",

                    LocalDate.of(1998,5,15)
            );


            studentRepository.saveAll(List.of(stud1 , stud2));

        };



    }
}
