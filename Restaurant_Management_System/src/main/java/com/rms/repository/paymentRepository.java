package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Payment;

@Repository
public interface paymentRepository extends JpaRepository<Payment, Long>{

}
