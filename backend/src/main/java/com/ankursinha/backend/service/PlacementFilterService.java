package com.ankursinha.backend.service;

import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.repo.PlacementFilterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementFilterService {

    @Autowired
    PlacementFilterRepo placementFilterRepo;

    public List<Placement> getEligiblePlacements(int domainId, int specialisationId){
        return placementFilterRepo.findByDomainAndSpecialisation(domainId, specialisationId);
    }
}
