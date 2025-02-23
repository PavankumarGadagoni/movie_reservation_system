package com.qsp.movie_reservation_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.movie_reservation_system.dto.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
