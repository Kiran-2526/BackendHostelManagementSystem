package com.mainPack.service;

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
}
