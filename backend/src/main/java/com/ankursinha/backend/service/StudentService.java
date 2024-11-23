package com.ankursinha.backend.service;

import com.ankursinha.backend.dto.LoginRequest;
import com.ankursinha.backend.dto.LoginResponse;
import com.ankursinha.backend.dto.StudentDetailsResponse;
import com.ankursinha.backend.entity.Student;
import com.ankursinha.backend.exception.StudentNotFoundException;
import com.ankursinha.backend.helper.EncryptionService;
import com.ankursinha.backend.helper.JWTHelper;
import com.ankursinha.backend.repo.DomainRepo;
import com.ankursinha.backend.repo.SpecialisationRepo;
import com.ankursinha.backend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    @Autowired
    JWTHelper jwtHelper;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    DomainRepo domainRepo;

    @Autowired
    SpecialisationRepo specialisationRepo;

    public LoginResponse login(LoginRequest request) {

        Student student = repo.findByEmail(request.email());

        if (student == null) {
            throw new StudentNotFoundException(format("Student with email %s not found", request.email()));
        }

        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        if (!auth.isAuthenticated()) {
            throw new BadCredentialsException("Invalid credentials provided");
        }

        String jwtToken = jwtHelper.generateToken(request.email());

        return new LoginResponse(jwtToken);
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

    public StudentDetailsResponse getStudentDetails(String email) {
        Student student = repo.findByEmail(email);

        String domainName = domainRepo.findNameById(student.getDomain().getDomainId());
        String specialisationName = specialisationRepo.findNameById(student.getSpecialisation().getSpecialisationId());

        return new StudentDetailsResponse(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getCgpa(),
                domainName,
                specialisationName
        );
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
