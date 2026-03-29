package com.mainPack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainPack.entity.Complaints;
import com.mainPack.service.ComplaintsService;


@RestController
@RequestMapping("/student")
public class ComplaintsController {
	
	@Autowired
	ComplaintsService service;
	
	@PostMapping("/postcomplaints")
	public Complaints postComplaints(@RequestBody Complaints complaint) {
		return service.postComplaints(complaint);
	}
}
