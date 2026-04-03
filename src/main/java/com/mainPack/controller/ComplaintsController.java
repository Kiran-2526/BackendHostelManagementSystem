package com.mainPack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainPack.entity.Complaints;
import com.mainPack.repository.ComplaintsRepo;
import com.mainPack.service.ComplaintsService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*") // ✅ required
public class ComplaintsController {
	
	@Autowired
	ComplaintsService service;

	@Autowired
	ComplaintsRepo repo;

	// ✅ POST complaint
	@PostMapping("/postcomplaints")
	public Complaints postComplaints(@RequestBody Complaints complaint) {
		return service.postComplaints(complaint);
	}

	// ✅ GET all complaints (for frontend display)
	@GetMapping("/getcomplaints")
	public List<Complaints> getAllComplaints() {
		return service.getAllComplaints();
	}
	
	@GetMapping("/getcomplaints/{rollNumber}")
	public List<Complaints> getComplaints(@PathVariable String rollNumber){
	    return service.getByRoll(rollNumber);
	}
	
	@PostMapping("/updateStatus/{id}")
	public Complaints updateStatus(@PathVariable int id) {

	    Complaints c = repo.findById(id).orElse(null);

	    if (c != null) {
	        c.setStatus("Resolved");
	        return repo.save(c);
	    }

	    return null;
	}
	
	@DeleteMapping("/deletecomplaint/{id}")
	public String deleteComplaint(@PathVariable int id) {
	    repo.deleteById(id);
	    return "Deleted Successfully";
	}
	
	@GetMapping("countcomplaints/{rollNumber}")
	public List<Complaints> countComplaints(@PathVariable String rollNumber) {
		return service.getByRoll(rollNumber);
	}
}