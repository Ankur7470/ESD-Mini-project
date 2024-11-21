package com.ankursinha.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "specialisation")
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisation_id")
    private Integer specialisationId;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    private Integer year;

    @Column(name = "credits_required")
    private Integer creditsRequired;
}

