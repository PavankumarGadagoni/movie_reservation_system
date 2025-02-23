package com.qsp.movie_reservation_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Branch;
import com.qsp.movie_reservation_system.dto.Screen;
import com.qsp.movie_reservation_system.dto.Staff;
import com.qsp.movie_reservation_system.service.BranchService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class BranchContoller {

	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {

		return branchService.saveBranch(branch);
	}
	
	@PutMapping("/addExistingScreenToExistingBranch")
	public ResponseStructure<Branch> addExistingScreenToExistingBranch(@RequestParam int screenId,@RequestParam int branchId) {
		 return branchService.addExistingScreenToExistingBranch(screenId, branchId);
	 }
	
	@PutMapping("/addExistingStaffToExistingBranch")
	public ResponseStructure<Branch> addExistingStaffToExistingBranch(@RequestParam int staffId,@RequestParam int branchId) {
		return branchService.addExistingStaffToExistingBranch(staffId, branchId);
	}
	
	@PutMapping("/addNewScreenToExistingBranch")
	public ResponseStructure<Branch> addNewScreenToExistingBranch(@RequestParam int branchId,@RequestBody Screen newScreen) {
		 return branchService.addNewScreenToExistingBranch(branchId, newScreen);
	 }
	
	@PutMapping("/addNewStaffToExistingBranch")
	public ResponseStructure<Branch> addNewStaffToExistingBranch(@RequestParam int branchId,@RequestBody Staff newStaff) {
		 return branchService.addNewStaffToExistingBranch(branchId, newStaff);
	 }
     
	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId) {

		return branchService.fetchBranchById(branchId);

	}
	
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int addressId,@RequestParam int branchId){
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}
	
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(@RequestParam int managerId,@RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}
     
	@PutMapping("/updateBranchById")
	public ResponseStructure<Branch> updateBranchById(@RequestParam int oldBranchId,@RequestBody Branch newBranch) {

		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	@GetMapping("/fetchAllBranch")
	public ResponseStructure1<Branch> fetchAllBranch() {

		return branchService.fetchAllBranch();
	}

	@DeleteMapping("/deleteBranchById")
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {

		return branchService.deleteBranchById(branchId);

	}
}
