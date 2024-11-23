package com.ankursinha.backend.service;

import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.Student;
import com.ankursinha.backend.exception.StudentNotFoundException;
import com.ankursinha.backend.repo.PlacementRepo;
import com.ankursinha.backend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepo placementRepo;

    @Autowired
    PlacementFilterService placementFilterService;

    @Autowired
    private StudentService studentService;

    public List<Placement> getEligiblePlacements(Long studentId) {

        Student student = studentService.getStudentById(studentId);

        if(student == null){
            throw new StudentNotFoundException(format("Student not found"));
        }

        float cgpa = student.getCgpa();
        int domainId = student.getDomain().getDomainId();
        int specialisationId = student.getSpecialisation().getSpecialisationId();

        List<Placement> placementsByCgpa = placementRepo.findEligiblePlacementsByCgpa(cgpa);
        List<Placement> placementsByFilter = placementFilterService.getEligiblePlacements(domainId, specialisationId);

        placementsByCgpa.retainAll(placementsByFilter);

        return placementsByCgpa;
    }
}
