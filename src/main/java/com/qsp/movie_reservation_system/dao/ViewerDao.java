package com.qsp.movie_reservation_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.movie_reservation_system.dto.Food;
import com.qsp.movie_reservation_system.dto.Seat;
import com.qsp.movie_reservation_system.dto.Ticket;
import com.qsp.movie_reservation_system.dto.Viewer;
import com.qsp.movie_reservation_system.repo.ViewerRepo;

@Repository
public class ViewerDao {

	@Autowired
	ViewerRepo viewerRepo;

	@Autowired
	SeatDao seatDao;
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	TicketDao ticketDao;

	public Viewer saveViewer(Viewer viewer) {
		return viewerRepo.save(viewer);
	}
	
	public Viewer addExistingTicketToExistingViewer(int ticketId,int viewerId) {
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		Viewer viewer=fetchViewerById(viewerId);
		List<Ticket> tickets =viewer.getTicket();
		tickets.add(ticket);
		return saveViewer(viewer);
		
	}
	
	public Viewer addNewTicketToExistingViewer(int viewerId,Ticket newTicket) {
		Viewer viewer=fetchViewerById(viewerId);
		List<Ticket> tickets =viewer.getTicket();
		tickets.add(newTicket);
		return saveViewer(viewer);
		
	}
	
	
	
	public Viewer addExistingFoodToExistingViewer(int foodId,int viewerId) {
		Food food=foodDao.fetchFoodById(foodId);
		Viewer viewer=fetchViewerById(viewerId);
		List<Food> foods =viewer.getFoods();
		foods.add(food);
		return saveViewer(viewer);
		
	}
	
	public Viewer addNewFoodToExistingViewer(int viewerId,Food newFood) {
		Viewer viewer=fetchViewerById(viewerId);
		List<Food> foods =viewer.getFoods();
		foods.add(newFood);
		return saveViewer(viewer);
	}

	public Viewer fetchViewerById(int viewerId) {

		Optional<Viewer> dbViewer = viewerRepo.findById(viewerId);
		
		if(dbViewer.isPresent()) return dbViewer.get();
		return null;
	}

	public Viewer addExistingSeatToExistingViewer(int seatId, int viewerId) {

		Seat seat = seatDao.fetchSeatById(seatId);
		Viewer viewer = fetchViewerById(viewerId);
		viewer.setSeat(seat);
		return saveViewer(viewer);

	}

	public Viewer updateViewerById(int oldViewerId, Viewer newViewer) {

		newViewer.setViewerId(oldViewerId);

		return saveViewer(newViewer);
	}

	public List<Viewer> fetchAllViewer() {

		return viewerRepo.findAll();
	}

	public Viewer deleteViewerById(int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		viewerRepo.delete(viewer);
		return viewer;
	}

}
