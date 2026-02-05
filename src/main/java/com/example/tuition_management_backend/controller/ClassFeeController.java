package com.example.tuition_management_backend.controller;

import com.example.tuition_management_backend.entity.ClassFee;
import com.example.tuition_management_backend.repository.ClassFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/class-fees")
public class ClassFeeController {

    @Autowired
    private ClassFeeRepository classFeeRepository;

    /**
     * Admin sets class-wise fee (CREATE)
     */
    @PostMapping
    public ClassFee createClassFee(@RequestBody ClassFee classFee) {
        return classFeeRepository.save(classFee);
    }

    /**
     * Admin updates class-wise fee (UPDATE)
     */
    @PutMapping("/{id}")
    public ClassFee updateClassFee(
            @PathVariable Long id,
            @RequestBody ClassFee updatedFee
    ) {
        ClassFee existingFee = classFeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class fee not found"));

        existingFee.setClassName(updatedFee.getClassName());
        existingFee.setAmount(updatedFee.getAmount());
        existingFee.setAcademicYear(updatedFee.getAcademicYear());
        existingFee.setActive(updatedFee.getActive());

        return classFeeRepository.save(existingFee);
    }

    /**
     * View all class fees
     */
    @GetMapping
    public List<ClassFee> getAllClassFees() {
        return classFeeRepository.findAll();
    }

    /**
     * Deactivate a class fee (soft delete)
     */
    @PutMapping("/{id}/deactivate")
    public ClassFee deactivateClassFee(@PathVariable Long id) {
        ClassFee fee = classFeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class fee not found"));

        fee.setActive(false);
        return classFeeRepository.save(fee);
    }
}
