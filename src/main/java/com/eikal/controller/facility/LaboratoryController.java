package com.eikal.controller.facility;

import com.eikal.models.facility.Laboratory;
import com.eikal.service.facility.LaboratoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LaboratoryController {

    private final LaboratoryService labService;

    public LaboratoryController(LaboratoryService labService) {
        this.labService = labService;
    }

    public ResponseEntity<?> save(Map<String, Object> map) {
        Laboratory laboratory = labService.saveLab(map);
        return laboratory != null ?
                ResponseEntity.status(201).body(laboratory) :
                ResponseEntity.status(415).build();
    }

    public ResponseEntity<?> findLab(Long id) {
        Laboratory laboratory = labService.findLab(id);
        return laboratory != null ?
                ResponseEntity.status(200).body(laboratory) :
                ResponseEntity.status(404).body("Laboratory not found");
    }

    public ResponseEntity<?> findLabsInFacility(Long id) {
        List<Laboratory> laboratories = labService.findLabsInFacility(id);
        return !laboratories.isEmpty() ?
                ResponseEntity.status(200).body(laboratories) :
                ResponseEntity.status(404).body("No laboratories in this facility");
    }

    public ResponseEntity<?> findLabsInDepartment(Long id) {
        List<Laboratory> laboratories = labService.findLabsInDepartment(id);
        return !laboratories.isEmpty() ?
                ResponseEntity.status(200).body(laboratories) :
                ResponseEntity.status(404).body("No laboratories in this department");
    }



}
