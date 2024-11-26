package com.ankursinha.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "placement")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String organisation;

    @Column(nullable = false)
    private String profile;

    private String description;

    @Column(nullable = false)
    private Integer intake;

    @Column(name = "minimum_grade")
    private Float minimumGrade;

    @Column(name = "photograph_path")
    private String photographPath;
}