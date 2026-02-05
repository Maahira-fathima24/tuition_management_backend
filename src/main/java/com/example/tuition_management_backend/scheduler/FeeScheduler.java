package com.example.tuition_management_backend.scheduler;


import com.example.tuition_management_backend.services.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FeeScheduler {
    @Autowired
    private FeeService feeService;
    /**
     * This method runs automatically on the 1st day of every month at 12:00 AM
     */
    @Scheduled(cron = "0 0 0 0 * ?")
    public void generateMonthlyFeesAutomatically() {
        feeService.generateMonthlyFees();
        System.out.println("Monthly fees generated automatically by scheduler");
    }
}
