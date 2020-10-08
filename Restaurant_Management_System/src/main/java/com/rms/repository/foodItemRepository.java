package com.rms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.foodItem;
 
@Repository
public interface foodItemRepository extends JpaRepository<foodItem, Long> {
	
	//retrieve food item by name
	public Optional<foodItem> getFoodItemByItemName(String itemName);

	@Transactional
	public void deleteFoodItemByItemName(String itemName);

}
