package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.InventoryManager;

@Repository
public interface inventoryManagerRepository extends JpaRepository<InventoryManager, Long>{

}
