package com.mainPack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mainPack.entity.Complaints;
import com.mainPack.service.ComplaintsService;
import com.mainPack.repository.ComplaintsRepo;

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
		return repo.findAll();
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
}