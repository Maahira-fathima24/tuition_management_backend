package com.example.tuition_management_backend.controller;


import com.example.tuition_management_backend.entity.Staff;
import com.example.tuition_management_backend.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/staffs")
public class AdminStaffController {

    @Autowired
    private StaffService staffService;

    //Get all staffs
    @GetMapping
    public List<Staff> getAllStaffs(){
        return staffService.getAllStaffs();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getStaffById(@PathVariable long id){
        return staffService.getStaffById(id);
    }

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff (@PathVariable int id,
                              @RequestBody Staff updatedStaff){
        return staffService.updateStaff((long)id, updatedStaff);
    }

    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable int id){
        staffService.deleteStaff((long)id);
        return "Staff deleted successfully";
    }
}
