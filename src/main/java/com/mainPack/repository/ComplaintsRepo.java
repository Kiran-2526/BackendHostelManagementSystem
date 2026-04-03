package com.mainPack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainPack.entity.Complaints;

public interface ComplaintsRepo extends JpaRepository<Complaints, Integer>{
	
	List<Complaints> findByRollNumber(String rollNumber);
	
}
