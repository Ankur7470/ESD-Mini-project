package com.ankursinha.backend.service;

import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.PlacementStudent;
import com.ankursinha.backend.repo.PlacementStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementStudentService {

    @Autowired
    PlacementStudentRepo placementStudentRepo;

    public List<Placement> getAppliedPlacements(Integer studentId) {
        return placementStudentRepo.findAppliedPlacements(studentId);
    }

    public PlacementStudent getByStudentIdandPlacementId(Integer studentId, Integer placementId) {
                return placementStudentRepo.findByStudentIdAndPlacementId(studentId, placementId);
    }
}
