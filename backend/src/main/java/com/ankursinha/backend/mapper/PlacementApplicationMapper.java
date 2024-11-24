package com.ankursinha.backend.mapper;

import com.ankursinha.backend.dto.PlacementApplicationRequest;
import org.springframework.stereotype.Component;

@Component
public class PlacementApplicationMapper {

    public PlacementApplicationRequest mapToPlacementApplicationRequest(PlacementApplicationRequest requestDTO) {
        return new PlacementApplicationRequest(
                requestDTO.placementId(),
                requestDTO.studentId(),
                requestDTO.cvFile(),
                requestDTO.about()
        );
    }
}
