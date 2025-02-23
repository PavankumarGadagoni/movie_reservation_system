package com.qsp.movie_reservation_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.movie_reservation_system.dto.Food;
import com.qsp.movie_reservation_system.dto.Ticket;
import com.qsp.movie_reservation_system.dto.Viewer;
import com.qsp.movie_reservation_system.service.ViewerService;
import com.qsp.movie_reservation_system.util.ResponseStructure;
import com.qsp.movie_reservation_system.util.ResponseStructure1;

@RestController
public class ViewerController {

	@Autowired
	ViewerService viewerService;

	@PostMapping("/saveViewer")
	public ResponseStructure<Viewer> saveViewer(@RequestBody Viewer viewer) {

		return viewerService.saveViewer(viewer);
	}
	@PutMapping("/addExistingTicketToExistingViewer")
	public ResponseStructure<Viewer> addExistingTicketToExistingViewer(@RequestParam int ticketId,@RequestParam int viewerId) {
		return viewerService.addExistingTicketToExistingViewer(ticketId, viewerId);
	}
	
	@PutMapping("/addNewTicketToExistingViewer")
	public ResponseStructure<Viewer> addNewTicketToExistingViewer(@RequestParam int viewerId,@RequestBody Ticket newTicket) {
		return viewerService.addNewTicketToExistingViewer(viewerId, newTicket);
	}
	
	@PutMapping("/addNewFoodToExistingViewer")
	public ResponseStructure<Viewer> addNewFoodToExistingViewer(@RequestParam int viewerId,@RequestParam Food newFood) {
		return viewerService.addNewFoodToExistingViewer(viewerId,newFood);
	}
	
	@PutMapping("/addExistingFoodToExistingViewer")
	public ResponseStructure<Viewer> addExistingFoodToExistingViewer(@RequestParam int foodId,@RequestParam int viewerId) {
		return viewerService.addExistingFoodToExistingViewer(foodId, viewerId);
	}
     
	@GetMapping("/fetchViewerById")
	public ResponseStructure<Viewer> fetchViewerById(@RequestParam int viewerId) {

		return viewerService.fetchViewerById(viewerId);

	}
	
	@PutMapping("/addExistingSeatToExistingViewer")
	public ResponseStructure<Viewer> addExistingSeatToExistingViewer(int seatId, int viewerId) {
		return viewerService.addExistingSeatToExistingViewer(seatId, viewerId);
	}
     
	@PutMapping("/updateViewerById")
	public ResponseStructure<Viewer> updateViewerById(@RequestParam int oldViewerId,@RequestBody Viewer newViewer) {

		return viewerService.updateViewerById(oldViewerId, newViewer);
	}

	@GetMapping("/fetchAllViewer")
	public ResponseStructure1<Viewer> fetchAllViewer() {

		return viewerService.fetchAllViewer();
	}

	@DeleteMapping("/deleteViewerById")
	public ResponseStructure<Viewer> deleteViewerById(@RequestParam int viewerId) {

		return viewerService.deleteViewerById(viewerId);

	}
}
