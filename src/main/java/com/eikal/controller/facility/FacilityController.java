package com.eikal.controller.facility;

import com.eikal.models.facility.Facility;
import com.eikal.service.facility.FacilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping("facility/save")
    public ResponseEntity<?> saveFacility(@RequestBody Map<String, Object> facility) {
        Facility savedFacility = facilityService.saveFacility(facility);
        if (savedFacility != null) {
            System.out.println(savedFacility);
            return ResponseEntity.status(201).body(savedFacility);
        }
        return ResponseEntity.status(415).body("Could not save facility");
    }

    @GetMapping("facility/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        Facility facility = facilityService.find(id);
        return facility != null ?
                ResponseEntity.status(200).body(facility) :
                ResponseEntity.status(404).body("Facility not found");
    }

    @GetMapping("facilities/org")
    public ResponseEntity<?> findAllInOrganization(@RequestParam("id") Long orgId) {
        List<Facility> facilities = facilityService.findAllInOrganization(orgId);
        return facilities != null ?
                ResponseEntity.status(200).body(facilities) :
                ResponseEntity.status(404).body("No facility found");
    }

    @GetMapping("facilities/search")
    public ResponseEntity<?> searchByName(@RequestParam("q") String name) {
        List<Facility> facilities = facilityService.searchByName(name);
        return facilities != null ?
                ResponseEntity.status(200).body(facilities) :
                ResponseEntity.status(404).body("Can't find facility");
    }

}
