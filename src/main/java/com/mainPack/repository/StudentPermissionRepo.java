package com.mainPack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainPack.entity.StudentPermission;

@Repository
public interface StudentPermissionRepo extends JpaRepository<StudentPermission, Integer>{
	
	List<StudentPermission> findByRollNumber(String rollNumber);
}
