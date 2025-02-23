package com.qsp.movie_reservation_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.movie_reservation_system.dto.Viewer;

public interface ViewerRepo extends JpaRepository<Viewer, Integer>{

}
