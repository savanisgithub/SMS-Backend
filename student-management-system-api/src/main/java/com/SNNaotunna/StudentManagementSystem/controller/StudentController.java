package com.SNNaotunna.StudentManagementSystem.controller;

import com.SNNaotunna.StudentManagementSystem.exception.StudentNotFoundException;
import com.SNNaotunna.StudentManagementSystem.model.Student;
import com.SNNaotunna.StudentManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent){
        return studentRepository.save(newStudent);
    }

    @GetMapping ("/student")
    List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException(id));
    }

    @PutMapping("/students/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id){
        return studentRepository.findById(id)
                .map(student ->{
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setAddress(newStudent.getAddress());
                    student.setBirthday(newStudent.getBirthday());
                    student.setDegreeProgram(newStudent.getDegreeProgram());
                    student.setCourse(newStudent.getCourse());
                    return studentRepository.save(student);

                }).orElseThrow(()->new StudentNotFoundException(id));
    }

    @DeleteMapping("/students/{id}")
    String deleteUser(@PathVariable Long id){
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
}
