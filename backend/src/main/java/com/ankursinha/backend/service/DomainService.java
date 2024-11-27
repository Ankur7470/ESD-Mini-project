package com.ankursinha.backend.service;

import com.ankursinha.backend.repo.DomainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainService {

    @Autowired
    DomainRepo domainRepo;

    public String getNameById(Integer domainId) {
        return domainRepo.findNameById(domainId);
    }
}
