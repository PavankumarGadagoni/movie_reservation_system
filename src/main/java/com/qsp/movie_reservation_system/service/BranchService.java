package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.AddressDao;
import com.qsp.movie_reservation_system.dao.BranchDao;
import com.qsp.movie_reservation_system.dao.ManagerDao;
import com.qsp.movie_reservation_system.dao.ScreenDao;
import com.qsp.movie_reservation_system.dao.StaffDao;
import com.qsp.movie_reservation_system.dto.Address;
import com.qsp.movie_reservation_system.dto.Branch;
import com.qsp.movie_reservation_system.dto.Manager;
import com.qsp.movie_reservation_system.dto.Screen;
import com.qsp.movie_reservation_system.dto.Staff;
import com.qsp.movie_reservation_system.exceptions.AddressIdNotFound;
import com.qsp.movie_reservation_system.exceptions.BranchIdNotFound;
import com.qsp.movie_reservation_system.exceptions.ManagerIdNotFound;
import com.qsp.movie_reservation_system.exceptions.ScreenIdNotFound;
import com.qsp.movie_reservation_system.exceptions.StaffIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	ScreenDao screenDao;

	@Autowired
	StaffDao staffDao;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	AddressDao addressDao;

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

	public ResponseStructure<Branch> addExistingScreenToExistingBranch(int screenId, int branchId) {

		Branch branch = branchDao.fetchBranchById(branchId);
		Screen screen = screenDao.fetchScreenById(screenId);
		if (branch != null && screen != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed screen to branch");
			responseStructure.setData(branchDao.addExistingScreenToExistingBranch(screenId, branchId));

			return responseStructure;
		} else {
			if (branch == null)
				throw new BranchIdNotFound();
			else
				throw new ScreenIdNotFound();
		}
	}

	public ResponseStructure<Branch> addNewScreenToExistingBranch(int branchId, Screen newScreen) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added new screen to branch");
			responseStructure.setData(branchDao.addNewScreenToExistingBranch(branchId, newScreen));

			return responseStructure;
		}
		throw new BranchIdNotFound();
	}

	public ResponseStructure<Branch> addNewStaffToExistingBranch(int branchId, Staff newStaff) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added new staff to branch");
			responseStructure.setData(branchDao.addNewStaffToExistingBranch(branchId, newStaff));

			return responseStructure;
		}
		throw new BranchIdNotFound();
	}

	public ResponseStructure<Branch> addExistingStaffToExistingBranch(int staffId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Staff staff = staffDao.fetchStaffById(staffId);
		if (branch != null && staff != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed staff to branch");
			responseStructure.setData(branchDao.addExistingStaffToExistingBranch(staffId, branchId));

			return responseStructure;
		} else {
			if (staff == null)
				throw new StaffIdNotFound();
			else
				throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int managerId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Manager manager = managerDao.fetchManagerById(managerId);
		if (branch != null && manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed manager to branch");
			responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));

			return responseStructure;
		} else {
			if (manager == null)
				throw new ManagerIdNotFound();
			else
				throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int addressId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		if (branch != null && address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully added existed address to branch");
			responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));

			return responseStructure;
		} else {
			if (address == null)
				throw new AddressIdNotFound();
			else
				throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Branch from Database");
			responseStructure.setData(branchDao.fetchBranchById(branchId));

			return responseStructure;
		}
		throw new BranchIdNotFound();

	}

	public ResponseStructure<Branch> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Branch updated into Database");
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));

			return responseStructure;
		}
		throw new BranchIdNotFound();

	}

	public ResponseStructure1<Branch> fetchAllBranch() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Branches fetched from Database");
		responseStructure1.setData(branchDao.fetchAllBranch());

		return responseStructure1;

	}

	public ResponseStructure<Branch> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch deleted into Database");
		responseStructure.setData(branchDao.deleteBranchById(branchId));

		return responseStructure;
		}
		throw new BranchIdNotFound();

	}

}
