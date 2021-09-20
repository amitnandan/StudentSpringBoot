package com.example.student.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    final private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }


    @PostMapping
    public  void registerNewStudent( @RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path ="{id}")
    public  void deleteStudent(@PathVariable("id") Long id)
    {
        studentService.deleteStudent(id);
    }


    @PutMapping(path="{id}")
    public void Update( @PathVariable("id") Long id,
                        @RequestParam(required = false) String name ,
                        @RequestParam(required = false) String email
                        )
    {
        studentService.updateStudent(id , name , email);

    }


}
