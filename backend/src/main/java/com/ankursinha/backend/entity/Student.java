package com.ankursinha.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "roll_num", nullable = false, unique = true)
    private String rollNum;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "photograph_path")
    private String photographPath;

    private Float cgpa;

    @Column(name = "total_credits")
    private Integer totalCredits;

    @Column(name = "graduation_year", nullable = false)
    private Integer graduationYear;

    @ManyToOne
    @JoinColumn(name = "domain", nullable = false)
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "specialisation", nullable = false)
    private Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "placement_id")
    private Placement placement;

    @Column(name = "password", nullable = false)
    private String password;
}
