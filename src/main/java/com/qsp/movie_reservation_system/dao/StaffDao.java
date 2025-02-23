package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Staff;
import com.qsp.movie_reservation_system.repo.StaffRepo;

@Repository
public class StaffDao {

	@Autowired
	StaffRepo staffRepo;

	public Staff saveStaff(Staff staff) {

		return staffRepo.save(staff);
	}

	public Staff fetchStaffById(int staffId) {
		
		Optional<Staff> dbStaff = staffRepo.findById(staffId);

		if(dbStaff.isPresent()) return dbStaff.get();
       return null;
	}
	public Staff updateStaffById(int oldStaffId,Staff newStaff) {
		
		newStaff.setStaffId(oldStaffId);
		return saveStaff(newStaff);
	}
	
	public List<Staff> fetchAllStaff(){
		
		return staffRepo.findAll();
	}

	public Staff deleteStaffById(int staffId){
		Staff staff = fetchStaffById(staffId);
		staffRepo.delete(staff);
		return staff;
	}
}
