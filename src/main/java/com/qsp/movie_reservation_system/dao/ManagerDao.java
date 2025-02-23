package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Manager;
import com.qsp.movie_reservation_system.repo.ManagerRepo;

@Repository
public class ManagerDao {
	
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {

		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int managerId) {
		
		Optional<Manager> dbManager = managerRepo.findById(managerId);

		if(dbManager.isPresent()) return dbManager.get();
		return null;

	}
	public Manager updateManagerById(int oldManagerId,Manager newManager) {
		
		newManager.setManagerId(oldManagerId);
		return saveManager(newManager);
	}
	
	public List<Manager> fetchAllManager(){
		
		return managerRepo.findAll();
	}

	public Manager deleteManagerById(int managerId){
		Manager manager = fetchManagerById(managerId);
		managerRepo.delete(manager);
		return manager;
	}

}
