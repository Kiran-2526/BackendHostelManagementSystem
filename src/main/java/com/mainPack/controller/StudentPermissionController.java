package com.mainPack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainPack.entity.StudentPermission;
import com.mainPack.service.StudentPermissionService;

@CrossOrigin(origins = "*")
@RequestMapping
@RestController
public class StudentPermissionController {

	@Autowired
	StudentPermissionService service;
	
	// Student request
    @PostMapping("/student/request-permission")
    public StudentPermission request(@RequestBody StudentPermission p) {
        return service.requestPermission(p);
    }

    // Warden view all
    @GetMapping("/all")
    public List<StudentPermission> getAll() {
        return service.getAll();
    }

    // Student own requests
    @GetMapping("/{roll}")
    public List<StudentPermission> getByRoll(@PathVariable String roll) {
        return service.getByRoll(roll);
    }

    // Approve
    @PutMapping("/warden/approve/{id}")
    public StudentPermission approve(@PathVariable int id) {
        return service.approve(id);
    }

    // Return
    @PutMapping("/warden/return/{id}")
    public StudentPermission returnBack(@PathVariable int id) {
        return service.markReturned(id);
    }
}
