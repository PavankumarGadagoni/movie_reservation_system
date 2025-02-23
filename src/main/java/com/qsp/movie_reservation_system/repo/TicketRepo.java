package com.qsp.movie_reservation_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.movie_reservation_system.dto.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}
