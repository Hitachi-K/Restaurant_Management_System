package com.rms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Reservation;

@Repository
public interface reservationRepository extends JpaRepository<Reservation, Long>{

	// Retrieves reservation by type
	Optional<Reservation> getReservationByType(String type);

}
 