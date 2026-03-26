package com.mainPack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainPack.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	Optional<Student> findByRollNumber(String rollNumber);
	
	boolean existsByRollNumber(String rollNumber);
}