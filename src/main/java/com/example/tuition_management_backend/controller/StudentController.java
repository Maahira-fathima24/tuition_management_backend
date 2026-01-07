package com.example.tuition_management_backend.controller;

import com.example.tuition_management_backend.model.Student;
import com.example.tuition_management_backend.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentServices studentServices;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentServices.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentServices.getStudentById(id);
    }

    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentServices.getStudentByName(name);

    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentServices.createStudent(student);

    }

    @PostMapping("/bulk")
    public List<Student> addStudents(@RequestBody List<Student> students){
        return studentServices.addAllStudents(students);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student){
        return studentServices.updateStudent(id , student);

    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentServices.deleteStudent(id);
        return "Student deleted successfully";
    }



}
