package com.eikal.controller.facility;

import com.eikal.models.facility.Laboratory;
import com.eikal.service.facility.LaboratoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
}
