package com.ankursinha.backend.controller;

import com.ankursinha.backend.dto.LoginRequest;
import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.Student;
import com.ankursinha.backend.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public void register(@RequestBody Student user) {
        studentService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        String response = studentService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{studentId}/eligible-placements")
    public ResponseEntity<List<Placement>> getEligiblePlacements(@PathVariable Long studentId) {
        List<Placement> eligiblePlacements = studentService.getEligiblePlacements(studentId);
        return ResponseEntity.ok(eligiblePlacements);
    }

}