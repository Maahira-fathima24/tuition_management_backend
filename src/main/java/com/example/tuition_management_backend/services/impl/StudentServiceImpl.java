package com.example.tuition_management_backend.services.impl;

import com.example.tuition_management_backend.entity.Student;
import com.example.tuition_management_backend.repository.StudentRepository;
import com.example.tuition_management_backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long studentId){
        return studentRepository.findById(studentId);
    }

    @Override
    public Student updateStudent(Long studentId, Student student){
        Student existingStudent = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setClassName(student.getClassName());
        existingStudent.setSection(student.getSection());
        existingStudent.setStatus(student.isStatus());

        return studentRepository.save(existingStudent);
    }
    @Override
    public void deleteStudent (Long studentId){
        studentRepository.deleteById(studentId);
    }


}
