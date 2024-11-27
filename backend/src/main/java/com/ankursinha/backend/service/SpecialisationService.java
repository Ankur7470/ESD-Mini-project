package com.ankursinha.backend.service;

import com.ankursinha.backend.repo.SpecialisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialisationService {

    @Autowired
    SpecialisationRepo specialisationRepo;

    public String getNameById(Integer specialisationId) {
        return specialisationRepo.findNameById(specialisationId);
    }
}
