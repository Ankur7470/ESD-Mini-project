package com.ankursinha.backend.service;

import com.ankursinha.backend.dto.PlacementApplicationRequest;
import com.ankursinha.backend.entity.Placement;
import com.ankursinha.backend.entity.PlacementStudent;
import com.ankursinha.backend.entity.Student;
import com.ankursinha.backend.exception.StudentNotFoundException;
import com.ankursinha.backend.helper.FileStorageService;
import com.ankursinha.backend.mapper.PlacementApplicationMapper;
import com.ankursinha.backend.repo.PlacementRepo;
import com.ankursinha.backend.repo.PlacementStudentRepo;
import com.ankursinha.backend.repo.StudentRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Autowired
    private PlacementStudentRepo placementStudentRepo;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private PlacementApplicationMapper placementApplicationMapper;

    public List<Placement> getEligiblePlacements(Integer studentId) {

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

    public void submitApplication(PlacementApplicationRequest requestDTO) throws Exception {

        PlacementApplicationRequest request = placementApplicationMapper.mapToPlacementApplicationRequest(requestDTO);

        String cvPath = fileStorageService.storeFile(request.cvFile(), "cvs");

        Student student = studentService.getStudentById(request.studentId());
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + request.studentId());
        }

        Placement placement = placementRepo.findById(request.placementId())
                .orElseThrow(() -> new RuntimeException("Placement not found with ID: " + request.placementId()));

        PlacementStudent application = new PlacementStudent();
        application.setPlacement(placement);
        application.setStudent(student);
        application.setCvApplication(cvPath);
        application.setAbout(request.about());
        application.setAcceptance(false); // Default value
        application.setComments("Pending review"); // Default value
        application.setDate(Timestamp.valueOf(LocalDateTime.now()));

        placementStudentRepo.save(application);
    }

    public List<Placement> getAppliedPlacements(Integer studentId) {
        return placementStudentRepo.findAppliedPlacements(studentId);
    }

    public String updatePhotograph(Integer placementId, MultipartFile file) throws IOException {
        Placement placement = placementRepo.findById(placementId)
                .orElseThrow(() -> new IllegalArgumentException("Placement with ID " + placementId + " does not exist."));

        String newPhotographPath = fileStorageService.storeFile(file, "companies_photos");

        placement.setPhotographPath(newPhotographPath);

        placementRepo.save(placement);

        return newPhotographPath;
    }

}
