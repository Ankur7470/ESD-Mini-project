package com.ankursinha.backend.repo;

import com.ankursinha.backend.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementRepo extends JpaRepository<Placement, Long> {
    @Query("SELECT p FROM Placement p WHERE p.minimumGrade <= :cgpa")
    List<Placement> findEligiblePlacementsByCgpa(@Param("cgpa") float cgpa);

}
