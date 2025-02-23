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
import com.qsp.movie_reservation_system.dto.Theatre;
import com.qsp.movie_reservation_system.service.TheatreService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class TheatreContoller {
	
	@Autowired
	TheatreService theatreService;
	
	@PostMapping("/saveTheatre")
	public ResponseStructure<Theatre> saveTheatre(@RequestBody Theatre theatre) {
		return theatreService.saveTheatre(theatre);
	} 
	
	@PutMapping("/addExistingbranchToExistingTheatre")
	public ResponseStructure<Theatre> addExistingbranchToExistingTheatre(@RequestParam int branchId,@RequestParam int theatreId) {
		return theatreService.addExistingbranchToExistingTheatre(branchId, theatreId);
	}
	
	@PutMapping("/addNewBranchToExistingTheatre")
	public ResponseStructure<Theatre> addNewBranchToExistingTheatre(@RequestParam int theatreId,@RequestBody Branch newBranch) {
		return theatreService.addExistingbranchToExistingTheatre(theatreId, theatreId);
	}
	
	@GetMapping("/fetchTheatreById")
	public ResponseStructure<Theatre> fetchTheatreById(@RequestParam int theatreId) {

		return theatreService.fetchTheatreById(theatreId);

	}
	
	@PutMapping("/updateTheatreById")
	public ResponseStructure<Theatre> updateTheatreById(@RequestParam int oldTheatreId,@RequestBody Theatre newTheatre) {
		
		
		return theatreService.updateTheatreById( oldTheatreId, newTheatre);
	}
	
	@GetMapping("/fetchAllTheatre")
	public ResponseStructure1<Theatre> fetchAllTheatre(){
		
		return theatreService.fetchAllTheatre();
	}

	@DeleteMapping("/deleteTheatreById")
	public ResponseStructure<Theatre> deleteTheatreById(@RequestParam int theatreId){
		

		return theatreService.deleteTheatreById(theatreId) ;
	}
}
