package com.example.student.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;

//import java.time.LocalDate;
import javax.transaction.Transactional;
import java.util.List;
import  java.util.Optional;

@Service
public class StudentService {

    final  private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent()
    {
        return
                studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional  = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw  new IllegalStateException("email is present use new one");
        }
        studentRepository.save(student);
    }


    public void deleteStudent(Long id) {

        if(!studentRepository.existsById(id))
        {
            throw new IllegalStateException("Student with id does not exists");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        if(studentRepository.existsById(id))
            throw  new IllegalStateException("Does not exists ");
        Student s = studentRepository.getById(id);
        if(  !s.getName().equalsIgnoreCase(name) && name != null && name.length()>0 )
        {
            s.setName(name);
        }
        if(  !s.getEmail().equalsIgnoreCase(email) && email != null && email.length()>0 ) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email Present from before choose something new");
            }
            s.setEmail(email);
        }
    }
}
