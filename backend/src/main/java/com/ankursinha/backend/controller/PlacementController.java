package com.ankursinha.backend.controller;

import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlacementController {

    @Autowired
    PlacementService placementService;

    @GetMapping("/placements/{studentId}")
    public ResponseEntity<List<Placement>> getEligiblePlacements(@PathVariable Long studentId) {
        List<Placement> eligiblePlacements = placementService.getEligiblePlacements(studentId);
        return ResponseEntity.ok(eligiblePlacements);
    }
}
