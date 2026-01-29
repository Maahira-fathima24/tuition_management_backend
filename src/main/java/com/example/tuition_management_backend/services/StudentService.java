package com.example.tuition_management_backend.services;
import com.example.tuition_management_backend.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    //Add a single student
    Student addStudent (Student student);

    // Get all students
    List<Student> getAllStudents();

    // Get student by ID
    Optional<Student> getStudentById(Long studentId);

    // Update student
    Student updateStudent(Long studentId, Student student);

    // Delete student
    void deleteStudent(Long studentId);

}
