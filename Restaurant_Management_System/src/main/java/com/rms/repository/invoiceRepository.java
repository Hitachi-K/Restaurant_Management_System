package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Invoice;

@Repository 
public interface invoiceRepository extends JpaRepository<Invoice, Long> {

}
