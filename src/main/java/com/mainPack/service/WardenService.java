package com.mainPack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainPack.entity.Warden;
import com.mainPack.repository.WardenRepo;

@Service
public class WardenService {
	
	@Autowired
	WardenRepo wardenrepo;
	
	public String register(Warden warden) {

	    if (wardenrepo.findByWardenId(warden.getWardenId()).isPresent()) {
	        return "Warden already exists";
	    }

	    wardenrepo.save(warden);
	    return "Registered Successfully";
		}
	
	public String login(String wardenId,String password) {

	    Warden warden = wardenrepo.findByWardenId(wardenId).orElse(null);

	    if (warden == null) {
	        return "Warden not found";
	    }

	    if (warden.getPassword().equals(password)) {
	        return "Login Success";
	    }

	    return "Invalid Password";
	}	
	
	public Warden getProfile(String wardenId) {
	    return wardenrepo.findByWardenId(wardenId)
	            .orElseThrow(() -> new RuntimeException("Warden not found"));
	}

	public String modify(Warden warden) {

	    Warden existing = wardenrepo.findByWardenId(warden.getWardenId())
	                                .orElse(null);

	    if (existing == null) {
	        return "Warden not found";
	    }

	    if (warden.getFullName() != null) {
	        existing.setFullName(warden.getFullName());
	    }

	    if (warden.getGender() != null) {
	        existing.setGender(warden.getGender());
	    }

	    if (warden.getEmail() != null) {
	        existing.setEmail(warden.getEmail());
	    }

	    if (warden.getPhone() != null) {
	        existing.setPhone(warden.getPhone());
	    }

	    if (warden.getPassword() != null) {
	        existing.setPassword(warden.getPassword());
	    }

	    wardenrepo.save(existing);

	    return "Updated Successfully";
	}
	
}