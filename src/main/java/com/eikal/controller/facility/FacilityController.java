package com.eikal.controller.facility;

import com.eikal.models.facility.Facility;
import com.eikal.service.facility.FacilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("facility")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveFacility(@RequestBody Map<String, Object> facility) {
        Facility savedFacility = facilityService.saveFacility(facility);
        if (savedFacility != null) {
            System.out.println(savedFacility);
            return ResponseEntity.status(201).body(savedFacility);
        }
        return ResponseEntity.status(415).body("Could not save facility");
    }
}
