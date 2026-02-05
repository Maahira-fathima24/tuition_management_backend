package com.example.tuition_management_backend.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "class_fee",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"class_name","academic_year"})
        }
)
public class ClassFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name", nullable = false, length = 10)
    private String className;   // Example: "10", "11", "11A"

    @Column(nullable = false)
    private Integer amount;     // Fee amount for the class

    @Column(name = "academic_year", nullable = false, length = 9)
    private String academicYear; // Example: "2025-26"

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Automatically set created time
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Constructors
    public ClassFee() {}

    public ClassFee(String className, Integer amount, String academicYear) {
        this.className = className;
        this.amount = amount;
        this.academicYear = academicYear;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
