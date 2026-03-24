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
}