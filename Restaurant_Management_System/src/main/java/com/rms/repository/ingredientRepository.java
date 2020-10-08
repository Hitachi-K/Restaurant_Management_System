package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.Ingredient;

@Repository 
public interface ingredientRepository extends JpaRepository<Ingredient, Long>{

}
