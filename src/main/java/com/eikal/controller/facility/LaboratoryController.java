package com.eikal.controller.facility;

import com.eikal.models.facility.Laboratory;
import com.eikal.models.patient.LabStaff;
import com.eikal.service.facility.LaboratoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LaboratoryController {

    private final LaboratoryService labService;

    public LaboratoryController(LaboratoryService labService) {
        this.labService = labService;
    }

    @PostMapping("laboratory/add")
    public ResponseEntity<?> save(@RequestBody Map<String, Object> map) {
        Laboratory laboratory = labService.saveLab(map);
        return laboratory != null ?
                ResponseEntity.status(201).body(laboratory) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("laboratory")
    public ResponseEntity<?> findLab(@RequestParam("id") Long id) {
        Laboratory laboratory = labService.findLab(id);
        return laboratory != null ?
                ResponseEntity.status(200).body(laboratory) :
                ResponseEntity.status(404).body("Laboratory not found");
    }

    @GetMapping("laboratory/facility")
    public ResponseEntity<?> findLabsInFacility(@RequestParam("id") Long id) {
        List<Laboratory> laboratories = labService.findLabsInFacility(id);
        return !laboratories.isEmpty() ?
                ResponseEntity.status(200).body(laboratories) :
                ResponseEntity.status(404).body("No laboratories in this facility");
    }

    @GetMapping("laboratory/department")
    public ResponseEntity<?> findLabsInDepartment(Long id) {
        List<Laboratory> laboratories = labService.findLabsInDepartment(id);
        return !laboratories.isEmpty() ?
                ResponseEntity.status(200).body(laboratories) :
                ResponseEntity.status(404).body("No laboratories in this department");
    }

    @PostMapping("laboratory/staff/save")
    public ResponseEntity<?> saveLabStaff(@RequestBody Map<String, Object> staff) {
        LabStaff labStaff = labService.saveLabStaff(staff);
        return labStaff != null ?
                ResponseEntity.status(201).body(labStaff) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("laboratory/staff")
    public ResponseEntity<?> findLabStaff(@RequestParam Long id) {
        LabStaff labStaff = labService.findLabStaff(id);
        return labStaff != null ?
                ResponseEntity.status(200).body(labStaff) :
                ResponseEntity.status(404).body("Could not find lab staff");
    }

    @GetMapping("laboratory/staffs")
    public ResponseEntity<?> findStaffInLab(@RequestParam Long labId){
        List<LabStaff> labStaffs = labService.findStaffInLab(labId);
        return !labStaffs.isEmpty() ?
                ResponseEntity.status(200).body(labStaffs) :
                ResponseEntity.status(404).body("No staffs in this laboratory");
    }

    @GetMapping("facility/lab-staffs")
    public ResponseEntity<?> findStaffInFacility(@RequestParam Long facilityId) {
        List<LabStaff> labStaffs = labService.findStaffInFacility(facilityId);
        return !labStaffs.isEmpty() ?
                ResponseEntity.status(200).body(labStaffs) :
                ResponseEntity.status(404).body("No laboratory staffs in this facility.");
    }

}
