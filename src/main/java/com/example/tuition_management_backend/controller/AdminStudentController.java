package com.example.tuition_management_backend.controller;

import com.example.tuition_management_backend.entity.Student;
import com.example.tuition_management_backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/students")
public class AdminStudentController {

    @Autowired
    private StudentService studentService;

    //Get all students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Get students by id
    @GetMapping("/{id}")
    public Optional getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    //Get students by name
    @GetMapping("/name/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }
    //Add a new Student
    @PostMapping
    public Student addStudent (@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //Update student details
    @PutMapping("/{id}")
    public Student updateStudent( @PathVariable int id,
                                  @RequestBody Student updatedStudent){
        return studentService.updateStudent((long)id,updatedStudent);
    }

    //Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent (@PathVariable int id){
        studentService.deleteStudent((long) id);
        return "Student deleted successfully";
    }






}
