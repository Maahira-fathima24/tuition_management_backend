package com.example.tuition_management_backend.controller;

import com.example.tuition_management_backend.entity.Fees;
import com.example.tuition_management_backend.services.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class AdminFeeController {

    @Autowired
    private FeeService feeService;

    /**
     * Generate monthly fees for all students
     * (Admin / System trigger)
     */
    @PostMapping("/generate")
    public String generateMonthlyFees() {
        feeService.generateMonthlyFees();
        return "Monthly fees generated successfully";
    }

    /**
     * Get fee history of a student
     */
    @GetMapping("/student/{studentId}")
    public List<Fees> getFeeByStudent(@PathVariable Long studentId) {
        return feeService.getFeeByStudentId(studentId);
    }

    /**
     * Admin marks a fee as PAID
     */
    @PutMapping("/{feeId}/pay")
    public Fees markFeeAsPaid(@PathVariable Long feeId) {
        return feeService.markFeeAsPaid(feeId);
    }
}
