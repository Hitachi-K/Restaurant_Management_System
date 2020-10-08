package com.rms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rms.model.chef;

@Repository 
public interface chefRepository extends JpaRepository<chef, Long>{
	
	//retrieve chef by last name
		public Optional<chef> getChefByLastName(String lastName);
		
		//delete chef by last name
		@Transactional
		public void deleteChefByLastName(String lastName);

}
