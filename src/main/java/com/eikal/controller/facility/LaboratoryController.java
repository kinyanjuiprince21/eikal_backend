package com.eikal.controller.facility;

import com.eikal.service.facility.LaboratoryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaboratoryController {

    private final LaboratoryService labService;

    public LaboratoryController(LaboratoryService labService) {
        this.labService = labService;
    }


}
