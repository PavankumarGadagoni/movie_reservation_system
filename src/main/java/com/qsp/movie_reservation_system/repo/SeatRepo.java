package com.qsp.movie_reservation_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.movie_reservation_system.dto.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>{

}
