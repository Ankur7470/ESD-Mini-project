package com.ankursinha.backend.controller;

import com.ankursinha.backend.dto.LoginRequest;
import com.ankursinha.backend.dto.LoginResponse;
import com.ankursinha.backend.dto.StudentDetailsResponse;
import com.ankursinha.backend.entity.Student;
import com.ankursinha.backend.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public void register(@RequestBody Student user) {
        studentService.register(user);
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