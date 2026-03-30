package com.mainPack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mainPack.entity.Warden;
import com.mainPack.service.WardenService;

@RestController
@RequestMapping("/warden")
@CrossOrigin(origins = "*")
public class WardenController {

    @Autowired
    WardenService wardenservice;

    @PostMapping("/register")
    public String register(@RequestBody Warden warden) {
        return wardenservice.register(warden);
    }

    @PostMapping("/login")
    public String login(@RequestBody Warden warden) {
        return wardenservice.login(warden.getWardenId(), warden.getPassword());
    }
    
    @GetMapping("/profile/{wardenId}")
    public Warden getProfile(@PathVariable String wardenId) {
        return wardenservice.getProfile(wardenId);
    }

    @PutMapping("/profile/update")
    public String update(@RequestBody Warden warden) {
        return wardenservice.modify(warden);
    }
}