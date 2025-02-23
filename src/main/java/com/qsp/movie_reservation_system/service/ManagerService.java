
package com.qsp.movie_reservation_system.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.movie_reservation_system.dao.ManagerDao;
import com.qsp.movie_reservation_system.dto.Manager;
import com.qsp.movie_reservation_system.exceptions.ManagerIdNotFound;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructure1<Manager> responseStructure1;
	
	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Managers inserted into Database");
		responseStructure.setData( managerDao.saveManager(manager));
		return responseStructure ;

	}

	public ResponseStructure<Manager> fetchManagerById(int managerId) {
		Manager manager=managerDao.fetchManagerById(managerId);
		if(manager != null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Manager fetched from Database");
		responseStructure.setData(managerDao.fetchManagerById(managerId) );
		return responseStructure ;
		}
        throw new ManagerIdNotFound();
	}
	public ResponseStructure<Manager> updateManagerById(int oldManagerId,Manager newManager) {
		Manager manager=managerDao.fetchManagerById(oldManagerId);
		if(manager != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager Updated into Database");
		responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
		return responseStructure ;
	}
    throw new ManagerIdNotFound();
	}
	
	public ResponseStructure1<Manager> fetchAllManager(){
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully All Managers fetched from Database");
		responseStructure1.setData(managerDao.fetchAllManager());

		return responseStructure1;
		
	}

	public ResponseStructure<Manager> deleteManagerById(int managerId){
		Manager manager=managerDao.fetchManagerById(managerId);
		if(manager != null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager deleted from Database");
		responseStructure.setData(managerDao.deleteManagerById(managerId));
		return responseStructure ;
		}
		throw new ManagerIdNotFound();
		
		
	}

}
