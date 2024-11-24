package com.ankursinha.backend.repo;

import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.PlacementStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementStudentRepo extends JpaRepository<PlacementStudent, Integer> {

    @Query("""
       SELECT p FROM Placement p 
       JOIN PlacementStudent ps ON p.id = ps.placement.id 
       WHERE ps.student.studentId = :studentId
       """)
    List<Placement> findAppliedPlacements(@Param("studentId") Integer studentId);
    @Query("SELECT ps FROM PlacementStudent ps WHERE ps.student.studentId = :studentId AND ps.placement.id = :placementId")
    PlacementStudent findByStudentIdAndPlacementId(@Param("studentId") Integer studentId, @Param("placementId") Integer placementId);//    List<PlacementStudent> findByPlacement_Id(Integer placementId);
}
