package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.model.review;

@Repository
public interface reviewRepository extends JpaRepository<review, Long>{

}
