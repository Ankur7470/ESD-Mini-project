package com.ankursinha.backend.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record PlacementApplicationRequest(

        @NotNull(message = "Placement ID is required")
        Integer placementId,

        @NotNull(message = "Student ID is required")
        Integer studentId,

        @NotNull(message = "CV file is required")
        MultipartFile cvFile,

        String about
) {
}
