package com.mainPack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainPack.entity.Student;
import com.mainPack.repository.StudentRepo;
import java.util.List;

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

    public List<Student> getAllStudents() {
        return studentrepo.findAll();
    }
    public void deleteStudent(int id) {
        studentrepo.deleteById(id);
    }
    
    public long getStudentCount() {
        return studentrepo.count();
    }
    
    public String modify(Student student) {

        Student existing = studentrepo.findByRollNumber(student.getRollNumber())
                                      .orElse(null);

        if (existing == null) {
            return "Student not found";
        }

        if (student.getFullName() != null) {
            existing.setFullName(student.getFullName());
        }

        if (student.getGender() != null) {
            existing.setGender(student.getGender());
        }

        if (student.getEmail() != null) {
            existing.setEmail(student.getEmail());
        }

        if (student.getPhone() != null) {
            existing.setPhone(student.getPhone());
        }

        if (student.getRoomNumber() != null) {
            existing.setRoomNumber(student.getRoomNumber());
        }

        if (student.getYear() != 0) {
            existing.setYear(student.getYear());
        }

        if (student.getPassword() != null) {
            existing.setPassword(student.getPassword());
        }

        studentrepo.save(existing);

        return "Updated Successfully";
    }
}