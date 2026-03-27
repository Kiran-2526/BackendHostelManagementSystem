package com.mainPack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mainPack.entity.Notice;
import com.mainPack.service.NoticeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // ➕ Add notice
    @PostMapping
    public Notice addNotice(@RequestBody Notice notice) {
        return noticeService.addNotice(notice);
    }

    // 📋 Get all notices
    @GetMapping
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }

    // ❌ Delete notice
    @DeleteMapping("/{id}")
    public String deleteNotice(@PathVariable int id) {
        noticeService.deleteNotice(id);
        return "Deleted Successfully";
    }
}