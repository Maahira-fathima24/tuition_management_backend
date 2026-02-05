package com.example.tuition_management_backend.services;

import com.example.tuition_management_backend.entity.Fees;

import java.util.List;

public interface FeeService {

    //system generates monthly fees
    void generateMonthlyFees();

    //view fee history of a student
    List<Fees> getFeeByStudentId(Long studentId);

    //Admin marks fee as paid
    Fees markFeeAsPaid(Long feeId);



}
