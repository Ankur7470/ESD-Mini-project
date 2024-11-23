package com.ankursinha.backend.repo;

import com.ankursinha.backend.entity.PlacementStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementStudentRepo extends JpaRepository<PlacementStudent, Long> {
}
