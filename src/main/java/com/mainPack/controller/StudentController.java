package com.mainPack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainPack.entity.Student;	
import com.mainPack.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    StudentService studentservice;

    @PostMapping("/register")
    public String register(@RequestBody Student student) {
        return studentservice.register(student);
    }

    @PostMapping("/login")
    public String login(@RequestBody Student student) {
        return studentservice.login(student.getRollNumber(),student.getPassword());
    }
}