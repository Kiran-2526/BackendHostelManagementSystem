package com.mainPack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainPack.entity.Warden;

@Repository
public interface WardenRepo extends JpaRepository<Warden, Integer>{
	
	Optional<Warden> findByWardenId(String wardenId);
}
