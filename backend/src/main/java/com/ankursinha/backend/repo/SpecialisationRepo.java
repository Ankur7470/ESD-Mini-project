package com.ankursinha.backend.repo;

import com.ankursinha.backend.entity.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepo extends JpaRepository<Specialisation, Integer> {
    @Query("SELECT s.name FROM Specialisation s WHERE s.specialisationId = :id")
    String findNameById(Integer id);
}
