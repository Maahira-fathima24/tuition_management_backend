package com.example.tuition_management_backend.services;

import com.example.tuition_management_backend.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    //method to add a single staff
    Staff addStaff (Staff staff);

    //Method to get all staffs
    List<Staff> getAllStaffs();



    //Method to get staff by ID
    Optional<Staff> getStaffById(Long staffId);

    //Method to update staff
    Staff updateStaff(Long staffId, Staff staff);

    //Delete a Staff
    void deleteStaff(Long staffId);



}
