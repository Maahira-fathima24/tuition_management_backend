package com.example.tuition_management_backend.services.impl;


import com.example.tuition_management_backend.entity.ClassFee;
import com.example.tuition_management_backend.entity.Fees;
import com.example.tuition_management_backend.entity.PaymentStatus;
import com.example.tuition_management_backend.entity.Student;
import com.example.tuition_management_backend.repository.ClassFeeRepository;
import com.example.tuition_management_backend.repository.FeesRepository;
import com.example.tuition_management_backend.repository.StudentRepository;
import com.example.tuition_management_backend.services.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
public class FeeServiceImpl implements FeeService {

    @Autowired
    private FeesRepository feeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassFeeRepository classFeeRepository;

    @Override
    public void generateMonthlyFees(){
        String currentMonth = YearMonth.now().toString();

        List<Student> students = studentRepository.findAll();

        for(Student student :students){
            Optional<Fees> existing =
                    feeRepository.findByStudentStudentIdAndFeeMonth(
                            student.getStudentId(),currentMonth
                    );
            if(existing.isPresent()){
                continue; //fee already generated
            }

            ClassFee classFee = classFeeRepository.findByClassNameAndActiveTrue(
                    student.getClassName())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Fee not set for class" + student.getClassName()
                            )
                    );
            Fees fees = new Fees();
            fees.setStudent(student);
            fees.setClass_name(student.getClassName());
            fees.setFee_amount(classFee.getAmount());
            fees.setFee_month(currentMonth);
            fees.setPaymentStatus(PaymentStatus.PENDING);

            feeRepository.save(fees);
        }

    }

    @Override
    public List<Fees> getFeeByStudentId(Long studentId){
        return feeRepository.findByStudentStudentId(studentId);
    }

    @Override
    public Fees markFeeAsPaid(Long Id){
        Fees fees = feeRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Fee record not found"));

        fees.setPaymentStatus(PaymentStatus.PAID);
        fees.setPaid_at(LocalDateTime.now());

        return feeRepository.save(fees);
    }

}
