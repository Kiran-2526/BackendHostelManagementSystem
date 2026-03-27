package com.mainPack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainPack.entity.Notice;

public interface NoticeRepo extends JpaRepository<Notice, Integer> {
	 List<Notice> findAllByOrderByCreatedAtDesc();
}