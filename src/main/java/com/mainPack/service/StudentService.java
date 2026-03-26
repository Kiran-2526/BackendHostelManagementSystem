package com.mainPack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainPack.entity.Student;
import com.mainPack.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentrepo;

    public String register(Student student) {

        if (studentrepo.findByRollNumber(student.getRollNumber()).isPresent()) {
            return "Student already exists";
        }

        studentrepo.save(student);
        return "Registered Successfully";
    }

    public String login(String rollNumber, String password) {

        Student student = studentrepo.findByRollNumber(rollNumber).orElse(null);

        if (student == null) {
            return "Student not found";
        }

        if (student.getPassword().equals(password)) {
            return "Login Success";
        }

        return "Invalid Password";
    }
    
    public Optional<Student> getProfile(String rollNumber) {
        return studentrepo.findByRollNumber(rollNumber);
    } 
}