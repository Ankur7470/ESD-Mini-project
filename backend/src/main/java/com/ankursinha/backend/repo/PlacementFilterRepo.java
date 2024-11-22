package com.ankursinha.backend.repo;

import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.PlacementFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementFilterRepo extends JpaRepository<PlacementFilter, Integer> {
    @Query("SELECT pf.placement FROM PlacementFilter pf WHERE (pf.specialisation.specialisationId = :specialisationId OR pf.specialisation IS NULL) AND (pf.domain.domainId = :domainId OR pf.domain IS NULL)")
    List<Placement> findByDomainAndSpecialisation(@Param("domainId") int domainId, @Param("specialisationId") int specialisationId);
}