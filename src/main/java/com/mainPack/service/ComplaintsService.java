package com.mainPack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainPack.entity.Complaints;
import com.mainPack.repository.ComplaintsRepo;

@Service
public class ComplaintsService {
	
	@Autowired
	ComplaintsRepo repo;
	
	public Complaints postComplaints(Complaints complaint) {
		return repo.save(complaint);
	}
	
	public List<Complaints> getByRoll(String rollNumber){
	    return repo.findByRollNumber(rollNumber);
	}
	
	public List<Complaints> getAllComplaints() {
		return repo.findAll();
	}
}
