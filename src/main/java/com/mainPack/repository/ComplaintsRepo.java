package com.mainPack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainPack.entity.Complaints;

public interface ComplaintsRepo extends JpaRepository<Complaints, Integer>{

}
