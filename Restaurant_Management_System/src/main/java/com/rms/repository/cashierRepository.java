package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Cashier;
 
@Repository
public interface cashierRepository extends JpaRepository<Cashier, Long> {

}
