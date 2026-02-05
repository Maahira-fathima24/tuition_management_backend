package com.example.tuition_management_backend.repository;

import com.example.tuition_management_backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface
StudentRepository extends JpaRepository<Student, Long> {
    // 🔹 Custom query methods (optional but useful)

    // Find students by class and section
    List<Student> findByClassNameAndSection(String className, String section);

    // Find active students
    List<Student> findByStatus(boolean status);

    // Check if phone number already exists
    boolean existsByPhone(String phone);

    //find students by name
    Student findByName(String name);


}
