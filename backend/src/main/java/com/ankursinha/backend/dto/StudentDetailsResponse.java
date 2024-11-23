package com.ankursinha.backend.dto;

public record StudentDetailsResponse(
        Integer studentId,
        String firstName,
        String lastName,
        String email,
        Float cgpa,
        String domainName,
        String specialisationName
) {}


