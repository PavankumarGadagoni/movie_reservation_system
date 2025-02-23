package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Address;
import com.qsp.movie_reservation_system.dto.Branch;
import com.qsp.movie_reservation_system.dto.Manager;
import com.qsp.movie_reservation_system.dto.Screen;
import com.qsp.movie_reservation_system.dto.Staff;
import com.qsp.movie_reservation_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	ScreenDao screenDao;
	
	public Branch saveBranch(Branch branch) {
		
		return branchRepo.save(branch);
	}
	
	public Branch addExistingStaffToExistingBranch(int staffId,int branchId) {
		
		Staff staff=staffDao.fetchStaffById(staffId);
		Branch branch = fetchBranchById(branchId);
		List<Staff> staffList =branch.getStaffList();
		staffList.add(staff);
		return saveBranch(branch);
	}
	public Branch addNewStaffToExistingBranch(int branchId,Staff newStaff) {
		Branch branch=fetchBranchById(branchId);
		List<Staff> staffList = branch.getStaffList();
		staffList.add(newStaff);
		return saveBranch(branch);
		
	}
	
	 public Branch addNewScreenToExistingBranch(int branchId,Screen newScreen) {
			
			Branch branch = fetchBranchById(branchId);
			List<Screen> screens =branch.getScreens();
			screens.add(newScreen);
			return saveBranch(branch);
			
		}
	
  public Branch addExistingScreenToExistingBranch(int screenId,int branchId) {
		
		Screen screen=screenDao.fetchScreenById(screenId);
		Branch branch = fetchBranchById(branchId);
		List<Screen> screens =branch.getScreens();
		screens.add(screen);
		return saveBranch(branch);
		
	}
	
	public Branch addExistingAddressToExistingBranch(int addressId,int branchId) {
		
		Address address=addressDao.fetchAddressById(addressId);
		Branch branch=fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
		
	}
	
	public Branch addExistingManagerToExistingBranch(int managerId,int branchId) {
		
		Manager manager=managerDao.fetchManagerById(managerId);
		Branch branch=fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
		
		
	}
	
	public Branch fetchBranchById(int branchId) {
		
		Optional<Branch> dbBranch = branchRepo.findById(branchId);
		
		if(dbBranch.isPresent()) {
			return dbBranch.get();
		}
		return null;
			
	}
	
	public Branch updateBranchById(int oldBranchId,Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		
		return saveBranch(newBranch);
	}
	
	public Branch deleteBranchById(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	public List<Branch> fetchAllBranch()
	{
		return branchRepo.findAll();
	}
}
