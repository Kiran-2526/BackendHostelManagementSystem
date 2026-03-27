package com.mainPack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mainPack.entity.Notice;
import com.mainPack.repository.NoticeRepo;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepo noticeRepo;

    public Notice addNotice(Notice notice) {
    	
        return noticeRepo.save(notice);
    }

    public List<Notice> getAllNotices() {
    	
        return noticeRepo.findAllByOrderByCreatedAtDesc();
    }

    public void deleteNotice(int id) {
    	
        noticeRepo.deleteById(id);
    }
}