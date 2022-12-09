package com.eikal.controller.patient;

import com.eikal.models.patient.MedicalDiagnosis;
import com.eikal.service.patient.MedicalDiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class MedicalDiagnosisController {

    private final MedicalDiagnosisService diagnosisService;

    @Autowired
    public MedicalDiagnosisController(MedicalDiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @PostMapping("diagnosis/save")
    public ResponseEntity<?> saveDiagnosis(Map<String, Object> map) {
        MedicalDiagnosis diagnosis = diagnosisService.saveDiagnosis(map);
        return diagnosis != null ?
                ResponseEntity.status(201).body(diagnosis) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("diagnosis/{id}")
    public ResponseEntity<?> findDiagnosis(@PathVariable Long id) {
        MedicalDiagnosis diagnosis = diagnosisService.findDiagnosis(id);
        return diagnosis != null ?
                ResponseEntity.status(200).body(diagnosis) :
                ResponseEntity.status(404).body("Diagnosis not found");
    }

    @GetMapping("diagnosis/facility")
    public ResponseEntity<?> getFacilityDiagnosis(@RequestParam("id") Long facilityId) {
        List<MedicalDiagnosis> diagnosis = diagnosisService.getFacilityDiagnosis(facilityId);
        return diagnosis != null ?
                ResponseEntity.status(200).body(diagnosis) :
                ResponseEntity.status(404).body("Diagnosis not found in this facility");
    }

    @GetMapping("diagnosis/patient")
    public ResponseEntity<?> getPatientDiagnosis(@RequestParam("ic") Long patientId) {
        List<MedicalDiagnosis> diagnosis = diagnosisService.getPatientDiagnosis(patientId);
        return diagnosis != null ?
                ResponseEntity.status(200).body(diagnosis) :
                ResponseEntity.status(404).body("Diagnosis not found for this patient");
    }

}