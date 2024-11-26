package com.ankursinha.backend.controller;

import com.ankursinha.backend.dto.PlacementApplicationRequest;
import com.ankursinha.backend.dto.PlacementApplicationResponse;
import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.PlacementStudent;
import com.ankursinha.backend.repo.PlacementStudentRepo;
import com.ankursinha.backend.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    PlacementService placementService;

    @Autowired
    PlacementStudentRepo placementStudentRepo;

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

    @GetMapping("/applied/{studentId}")
    public ResponseEntity<List<Placement>> getAppliedPlacements(@PathVariable Integer studentId) {
        List<Placement> appliedPlacements = placementService.getAppliedPlacements(studentId);
        return ResponseEntity.ok(appliedPlacements);
    }

    @GetMapping("/status/{studentId}/{placementId}")
    public ResponseEntity<PlacementStudent> getPlacementStatus(
            @PathVariable Integer studentId,
            @PathVariable Integer placementId) {

        PlacementStudent application = placementStudentRepo.findByStudentIdAndPlacementId(studentId, placementId);
        return ResponseEntity.ok(application);
    }

@PostMapping("/updatePhotograph/{id}")
public ResponseEntity<String> updatePhotograph(@PathVariable("id") Integer placementId,
                                               @RequestPart("file") MultipartFile file) {
    try {
        String photographPath = placementService.updatePhotograph(placementId, file);

        return ResponseEntity.ok("Photograph updated successfully. New path: " + photographPath);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

}
