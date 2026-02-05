package com.example.tuition_management_backend.entity;

import com.example.tuition_management_backend.entity.Student;
import jakarta.persistence.*;
import com.example.tuition_management_backend.entity.PaymentStatus;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Entity
@Table(
        name ="fees",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"student_id", "fee_month"})
        }
)
public class Fees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fees_id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "class_name", nullable = false, length =10)
    private String class_name;

    @Column(name = "fee_month", nullable = false, length=7)
    private String feeMonth;

    @Column(name ="fee_amount", nullable = false)
    private Integer fee_amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus payment_status = PaymentStatus.PENDING;

    @Column(name = "paid_at")
    private LocalDateTime paid_at;

    @PrePersist
    protected void onCreate(){
        if(this.feeMonth == null){
            this.feeMonth = YearMonth.now().toString();
        }

        if(this.payment_status == null){
            this.payment_status = PaymentStatus.PENDING;
        }
    }

    public Long getFees_id() {
        return fees_id;
    }

    public void setFees_id(Long fees_id) {
        this.fees_id = fees_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getFee_month() {
        return feeMonth;
    }

    public void setFee_month(String fee_month) {
        this.feeMonth = fee_month;
    }

    public Integer getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(Integer fee_amount) {
        this.fee_amount = fee_amount;
    }

    public PaymentStatus getPaymentStatus() {
        return payment_status;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.payment_status = paymentStatus;
    }

    public LocalDateTime getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(LocalDateTime paid_at) {
        this.paid_at = paid_at;
    }
}
