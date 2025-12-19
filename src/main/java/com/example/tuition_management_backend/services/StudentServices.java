package com.example.tuition_management_backend.services;

import com.example.tuition_management_backend.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.service.registry.ImportHttpServices;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {
    private List<Student> students = new ArrayList<>();

    public StudentServices(){
        students.add(new Student(1L ,"Aisha", "10"));
        students.add(new Student(2L , "Sara", "12"));
        students.add(new Student(3L, "Neha", "11"));
        students.add(new Student (5L, "Zehra","5"));
        students.add(new Student(4L,"Zafina","12"));

    }
 //Get all students
    public List<Student> getAllStudents(){
        return students;
    }

    //Get student by Id
    public Student getStudentById(Long id){
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not Found"));

    }
    //Get student by name
    public Student getStudentByName(String name){
        return students.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student name not found"));
    }

    //Post or create student
    public Student createStudent(Student student){
        students.add(student);
        return student;
    }

    //Put update student
    public Student updateStudent(Long id , Student student){
        Student existing = getStudentById(id);

        existing.setName(student.getName());
        existing.setClassLevel(student.getClassLevel());

        return existing;
    }

    //Delete student
    public void deleteStudent(Long id){
        students.removeIf(s -> s.getId().equals(id));
    }






}
