package com.rms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Customer;

@Repository
public interface customerRepository extends JpaRepository<Customer, Long>{
	
	//Retrieve Customer by type
	public Optional<Customer> getCustomerByType(String type);

}
