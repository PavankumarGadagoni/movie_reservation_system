package com.qsp.movie_reservation_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.movie_reservation_system.dto.Owner;

public interface OwnerRepo extends JpaRepository<Owner,Integer> {

}
