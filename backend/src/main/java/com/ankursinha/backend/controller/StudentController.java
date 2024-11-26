package com.ankursinha.backend.controller;

import com.ankursinha.backend.dto.LoginRequest;
import com.ankursinha.backend.dto.LoginResponse;
import com.ankursinha.backend.dto.StudentDetailsResponse;
//import com.ankursinha.backend.entity.Student;
import com.ankursinha.backend.service.StudentService;
//import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestPart("student") String studentJson,
                                           @RequestPart("file") MultipartFile file) {
        try {
            studentService.register(studentJson, file);
            return ResponseEntity.ok("Student registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        LoginResponse response = studentService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/details/{email}")
    public ResponseEntity<StudentDetailsResponse> getStudentDetails(@PathVariable String email) {
        StudentDetailsResponse res = studentService.getStudentDetails(email);
        return ResponseEntity.ok(res);
    }

}