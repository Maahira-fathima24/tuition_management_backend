package com.example.tuition_management_backend.repository;

import com.example.tuition_management_backend.entity.Fees;
import com.example.tuition_management_backend.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeesRepository extends JpaRepository<Fees, Long> {

    //prevent duplicate monthly fees
    Optional<Fees> findByStudentStudentIdAndFeeMonth (Long studentId, String feeMonth);

    //Fee history of a student
    List<Fees> findByStudentStudentId(Long studentId);

    //All pending/paid fees
    List<Fees> findByPaymentStatus(PaymentStatus paymentStatus);

    //pending fees of a student
    List<Fees> findByStudentStudentIdAndPaymentStatus(
            Long studentId,
            PaymentStatus paymentStatus);



}
