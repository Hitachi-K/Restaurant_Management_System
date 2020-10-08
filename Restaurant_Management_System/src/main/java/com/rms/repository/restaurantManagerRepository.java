package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.RestaurantManager;

@Repository
public interface restaurantManagerRepository extends JpaRepository<RestaurantManager, Long> {
 
}
