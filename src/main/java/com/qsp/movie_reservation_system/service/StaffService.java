package com.qsp.movie_reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.StaffDao;
import com.qsp.movie_reservation_system.dto.Staff;
import com.qsp.movie_reservation_system.exceptions.StaffIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class StaffService {

	@Autowired
	StaffDao staffDao;
	
	@Autowired
	ResponseStructure<Staff> responseStructure;
	
	@Autowired
	ResponseStructure1<Staff> responseStructure1;
	
	
	
	public ResponseStructure<Staff> saveStaff(Staff staff) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Staff insterted into Database");
		responseStructure.setData(staffDao.saveStaff(staff));

		return responseStructure;
	}

	public ResponseStructure<Staff> fetchStaffById(int staffId) {
	     Staff dbStaff=staffDao.fetchStaffById(staffId);
	     if(dbStaff != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Staff Fetched from Database");
        responseStructure.setData(staffDao.fetchStaffById(staffId));
		return responseStructure;
	     }
	     throw new StaffIdNotFound();

	}
	public ResponseStructure<Staff> updateStaffById(int oldStaffId,Staff newStaff) {
		  Staff dbStaff=staffDao.fetchStaffById(oldStaffId);
		     if(dbStaff != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff Updated from Database");
		responseStructure.setData(staffDao.updateStaffById(oldStaffId, newStaff));
		return responseStructure ;
		     }
		     throw new StaffIdNotFound();
	}
	
	public ResponseStructure1<Staff> fetchAllStaff(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Staffs fetched from Database");
		responseStructure1.setData(staffDao.fetchAllStaff());
		return responseStructure1;
		
	}

	public ResponseStructure<Staff> deleteStaffById(int staffId){
		 Staff dbStaff=staffDao.fetchStaffById(staffId);
	     if(dbStaff != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff delete from Database");
		responseStructure.setData(staffDao.deleteStaffById(staffId));
		return responseStructure ;
	     }
	     throw new StaffIdNotFound();
		
	}
	
}
