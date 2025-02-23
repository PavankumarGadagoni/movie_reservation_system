package com.qsp.movie_reservation_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Manager;
import com.qsp.movie_reservation_system.service.ManagerService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager) {

		return managerService.saveManager(manager);
	}
     
	@GetMapping("/fetchManagerById")
	public ResponseStructure<Manager> fetchManagerById(@RequestParam int managerId) {

		return managerService.fetchManagerById(managerId);

	}
     
	@PutMapping("/updateManagerById")
	public ResponseStructure<Manager> updateManagerById(@RequestParam int oldManagerId,@RequestBody Manager newManager) {

		return managerService.updateManagerById(oldManagerId, newManager);
	}

	@GetMapping("/fetchAllManager")
	public ResponseStructure1<Manager> fetchAllManager() {

		return managerService.fetchAllManager();
	}

	@DeleteMapping("/deleteManagerById")
	public ResponseStructure<Manager> deleteManagerById(@RequestParam int managerId) {

		return managerService.deleteManagerById(managerId);

	}
}
