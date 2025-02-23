package com.qsp.movie_reservation_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.BranchDao;
import com.qsp.movie_reservation_system.dto.Branch;

import com.qsp.movie_reservation_system.dto.Screen;
import com.qsp.movie_reservation_system.dto.Staff;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	
	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	@Autowired
	ResponseStructure1<Branch> responseStructure1;

	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully branch insterted into Database");
		responseStructure.setData(branchDao.saveBranch(branch));

		return responseStructure;

	
	}
	 public ResponseStructure<Branch> addExistingScreenToExistingBranch(int screenId,int branchId) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed screen to branch");
			responseStructure.setData(branchDao.addExistingScreenToExistingBranch(screenId, branchId));

			return responseStructure;
	 }
	 public ResponseStructure<Branch> addNewScreenToExistingBranch(int branchId,Screen newScreen) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added new screen to branch");
			responseStructure.setData(branchDao.addNewScreenToExistingBranch(branchId, newScreen));

			return responseStructure;
	 }
	 
	 public ResponseStructure<Branch> addNewStaffToExistingBranch(int branchId,Staff newStaff) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added new staff to branch");
			responseStructure.setData(branchDao.addNewStaffToExistingBranch(branchId, newStaff));

			return responseStructure;
	 }

	public ResponseStructure<Branch> addExistingStaffToExistingBranch(int staffId, int branchId) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed staff to branch");
			responseStructure.setData(branchDao.addExistingStaffToExistingBranch(staffId,branchId));

			return responseStructure;
	
	}

	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int managerId, int branchId) {

		 responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed manager to branch");
			responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));

			return responseStructure;
	}

	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int addressId, int branchId) {
		 responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed address to branch");
			responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));

			return responseStructure;
	}

	public ResponseStructure<Branch> fetchBranchById(int branchId) {
		 responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Branch from Database");
			responseStructure.setData(branchDao.fetchBranchById(branchId));

			return responseStructure;

	}

	public ResponseStructure<Branch> updateBranchById(int oldBranchId, Branch newBranch) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch updated into Database");
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));

		return responseStructure;

	}

	public ResponseStructure1<Branch> fetchAllBranch() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Branches fetched from Database");
		responseStructure1.setData(branchDao.fetchAllBranch());

		return responseStructure1;

	}

	public ResponseStructure<Branch> deleteBranchById(int branchId) {
		
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch deleted into Database");
		responseStructure.setData(branchDao.deleteBranchById(branchId));

		return responseStructure;


	}

}
