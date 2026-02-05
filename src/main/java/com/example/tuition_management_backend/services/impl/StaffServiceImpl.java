package com.example.tuition_management_backend.services.impl;


import com.example.tuition_management_backend.entity.Staff;
import com.example.tuition_management_backend.repository.StaffRepository;
import com.example.tuition_management_backend.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff addStaff (Staff staff){
        return staffRepository.save(staff);
    }
    @Override
    public List<Staff> getAllStaffs(){
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long staffId){
        return staffRepository.findById(staffId);
    }






    @Override
    public Staff updateStaff(Long staffId, Staff staff){
        Staff existingStaff = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        existingStaff.setName(staff.getName());
        existingStaff.setPhone(staff.getPhone());
        existingStaff.setSubject(staff.getSubject());
        existingStaff.setStatus(staff.getStatus());

        return staffRepository.save(existingStaff);

    }

    @Override
    public void deleteStaff(Long staffId){
        staffRepository.deleteById(staffId);
    }


}
