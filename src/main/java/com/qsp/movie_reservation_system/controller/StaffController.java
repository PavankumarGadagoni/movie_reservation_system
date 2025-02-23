package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Staff;
import com.qsp.movie_reservation_system.service.StaffService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class StaffController {
	
	@Autowired
	StaffService staffService;

	@PostMapping("/saveStaff")
	public ResponseStructure<Staff> saveStaff(@RequestBody Staff staff) {

		return staffService.saveStaff(staff);
	}
     
	@GetMapping("/fetchStaffById")
	public ResponseStructure<Staff> fetchStaffById(@RequestParam int staffId) {

		return staffService.fetchStaffById(staffId);

	}
     
	@PutMapping("/updateStaffById")
	public ResponseStructure<Staff> updateStaffById(@RequestParam int oldStaffId,@RequestBody Staff newStaff) {

		return staffService.updateStaffById(oldStaffId, newStaff);
	}

	@GetMapping("/fetchAllStaff")
	public ResponseStructure1<Staff> fetchAllStaff() {

		return staffService.fetchAllStaff();
	}

	@DeleteMapping("/deleteStaffById")
	public ResponseStructure<Staff> deleteStaffById(@RequestParam int staffId) {

		return staffService.deleteStaffById(staffId);

	}

	
}
