package com.example.student.Student;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity

public class Student {
    @SequenceGenerator(
            name ="student_id",
            sequenceName = "student_id",
            allocationSize = 1
    )
    @GeneratedValue( strategy = GenerationType.SEQUENCE,
    generator = "student_id"
    )
    @Id
    private Long id;
    private String name ;
    private String email;
    @Transient
    private Integer age;

    private LocalDate dob;

    public Student()
    {

    }



    public Student(String name, String email,  LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id ;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob , LocalDate.now()).getYears();

    }


    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +

                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }

}
