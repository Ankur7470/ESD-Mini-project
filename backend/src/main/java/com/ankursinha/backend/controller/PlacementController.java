package com.ankursinha.backend.controller;

import com.ankursinha.backend.dto.PlacementApplicationRequest;
import com.ankursinha.backend.dto.PlacementApplicationResponse;
import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    PlacementService placementService;

    @GetMapping("/{studentId}")
    public ResponseEntity<List<Placement>> getEligiblePlacements(@PathVariable Integer studentId) {
        List<Placement> eligiblePlacements = placementService.getEligiblePlacements(studentId);
        return ResponseEntity.ok(eligiblePlacements);
    }

    @PostMapping("/apply")
    public ResponseEntity<PlacementApplicationResponse> applyForPlacement(
            @ModelAttribute PlacementApplicationRequest requestDTO) {

        try {
            placementService.submitApplication(requestDTO);
            return ResponseEntity.ok(new PlacementApplicationResponse("Application submitted successfully"));
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PlacementApplicationResponse("Error: " + e.getMessage()));
        }
    }

}
