package com.mainPack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/profile/{rollNumber}")
    public Student getProfile(@PathVariable String rollNumber) {
        return studentservice.getProfile(rollNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentservice.getAllStudents();
    }
    
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentservice.deleteStudent(id);
        return "Deleted Successfully";
    }
    
    @PutMapping("/profile/update")
    public String update(@RequestBody Student student) {
        return studentservice.modify(student);
    }
    
    @GetMapping("/count")
    public long getStudentCount() {
        return studentservice.getStudentCount();
    }
}	
