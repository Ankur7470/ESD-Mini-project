package com.ankursinha.backend.service;

import com.ankursinha.backend.dto.LoginRequest;
import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.Student;
import com.ankursinha.backend.exception.StudentNotFoundException;
import com.ankursinha.backend.helper.EncryptionService;
import com.ankursinha.backend.helper.JWTHelper;
import com.ankursinha.backend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;


@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    @Autowired
    PlacementService placementService;

    @Autowired
    PlacementFilterService placementFilterService;

    @Autowired
    JWTHelper jwtHelper;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    EncryptionService encryptionService;

    public String login(LoginRequest request) {

        Student student = repo.findByEmail(request.email());

        if (student == null) {
            throw new StudentNotFoundException(format("Student with email %s not found", request.email()));
        }

        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        if(auth.isAuthenticated())
            return jwtHelper.generateToken(request.email());

        throw new BadCredentialsException("Invalid credentials provided");
    }

    public void register(Student student) {

        if (student.getRollNum() == null || student.getEmail() == null || student.getPassword() == null) {
            throw new IllegalArgumentException("Roll number, email, and password are mandatory fields.");
        }

        if (repo.existsByRollNum(student.getRollNum())) {
            throw new IllegalArgumentException("A student with the same roll number already exists.");
        }

        if (repo.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("A student with the same email already exists.");
        }
        student.setPassword(encryptionService.encode(student.getPassword()));
        repo.save(student);
    }

    public List<Placement> getEligiblePlacements(Long studentId) {

        Student student = repo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        float cgpa = student.getCgpa();
        int domainId = student.getDomain().getDomainId();
        int specialisationId = student.getSpecialisation().getSpecialisationId();

        List<Placement> placementsByCgpa = placementService.getEligiblePlacementsByCgpa(cgpa);
        List<Placement> placementsByFilter = placementFilterService.getEligiblePlacements(domainId, specialisationId);

        placementsByCgpa.retainAll(placementsByFilter);

        return placementsByCgpa;
    }


}
