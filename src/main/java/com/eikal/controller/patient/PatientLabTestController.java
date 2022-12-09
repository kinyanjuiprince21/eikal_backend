package com.eikal.controller.patient;

import com.eikal.models.patient.PatientLabTest;
import com.eikal.service.patient.PatientLabTestService;
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
public class PatientLabTestController {

    private final PatientLabTestService labTestService;

    @Autowired
    public PatientLabTestController(PatientLabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @PostMapping("lab-test/save")
    public ResponseEntity<?> save(@RequestBody Map<String, Object> map) {
        PatientLabTest labTest = labTestService.save(map);
        return labTest != null ?
                ResponseEntity.status(201).body(labTest) :
                ResponseEntity.status(415).build();
    }

    @GetMapping("lab-test/{id}")
    public ResponseEntity<?> findTest(@PathVariable Long id) {
        PatientLabTest labTest = labTestService.findTest(id);
        return labTest != null ?
                ResponseEntity.status(200).body(labTest) :
                ResponseEntity.status(404).body("Test not found");
    }

    @GetMapping("lab-test/laboratory")
    public ResponseEntity<?> labTests(@RequestParam Long id) {
        List<PatientLabTest> labTests = labTestService.labTests(id);
        return labTests != null ?
                ResponseEntity.status(200).body(labTests) :
                ResponseEntity.status(404).body("Laboratory have no tests.");
    }

    @GetMapping("lab-test/facility")
    public ResponseEntity<?> facilityLabTests(@RequestParam Long id) {
        List<PatientLabTest> labTests = labTestService.facilityLabTests(id);
        return labTests != null ?
                ResponseEntity.status(200).body(labTests) :
                ResponseEntity.status(404).body("facility have no lab tests.");
    }

}
