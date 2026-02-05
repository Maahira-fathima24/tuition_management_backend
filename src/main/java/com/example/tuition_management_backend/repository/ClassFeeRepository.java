package com.example.tuition_management_backend.repository;

import com.example.tuition_management_backend.entity.ClassFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassFeeRepository extends JpaRepository<ClassFee, Long> {
    Optional<ClassFee> findByClassNameAndActiveTrue(String className);
}
