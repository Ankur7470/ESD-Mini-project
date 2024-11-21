package com.ankursinha.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "domains")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private Integer domainId;

    @Column(nullable = false)
    private String program;

    @Column(nullable = false)
    private String batch;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String qualification;
}

