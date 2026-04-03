package com.mainPack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainPack.entity.StudentPermission;
import com.mainPack.repository.StudentPermissionRepo;

@Service
public class StudentPermissionService {
	
	@Autowired
	StudentPermissionRepo repo;
	
	public StudentPermission requestPermission(StudentPermission permission) {
		permission.setStatus("Pending");
		return repo.save(permission);
	}
	
	// Warden get all
    public List<StudentPermission> getAll() {
        return repo.findAll();
    }

    // Student get own
    public List<StudentPermission> getByRoll(String roll) {
        return repo.findByRollNumber(roll);
    }

    // Approve
    public StudentPermission approve(int id) {
    	StudentPermission p = repo.findById(id).orElse(null);
        if (p != null) {
            p.setStatus("Approved");
            return repo.save(p);
        }
        return null;
    }

    // Return
    public StudentPermission markReturned(int id) {
    	StudentPermission p = repo.findById(id).orElse(null);
        if (p != null) {
            p.setStatus("Returned");
            return repo.save(p);
        }
        return null;
    }
    public void delete(int id) {
        repo.deleteById(id);
    }
}
