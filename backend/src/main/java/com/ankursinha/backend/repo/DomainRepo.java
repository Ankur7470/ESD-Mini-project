package com.ankursinha.backend.repo;

import com.ankursinha.backend.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepo extends JpaRepository<Domain, Integer> {
    @Query("SELECT d.program FROM Domain d WHERE d.domainId = :id")
    String findNameById(Integer id);
}
