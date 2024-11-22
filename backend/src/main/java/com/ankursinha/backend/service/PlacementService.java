package com.ankursinha.backend.service;

import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.repo.PlacementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepo placementRepo;

    public List<Placement> getEligiblePlacementsByCgpa(float cgpa) {
        return placementRepo.findEligiblePlacementsByCgpa(cgpa);
    }

}
