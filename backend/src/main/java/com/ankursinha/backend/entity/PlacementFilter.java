package com.ankursinha.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "placement_filter")
public class PlacementFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "placement_id", nullable = false)
    private Placement placement;

    @ManyToOne
    @JoinColumn(name = "specialisation")
    private Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "domain")
    private Domain domain;
}

