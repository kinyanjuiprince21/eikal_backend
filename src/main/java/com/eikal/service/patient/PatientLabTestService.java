package com.eikal.service.patient;

import com.eikal.models.patient.PatientLabTest;
import com.eikal.repository.patient.PatientLabTestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PatientLabTestService {

    private final PatientLabTestRepository testRepository;

    @Autowired
    public PatientLabTestService(PatientLabTestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public PatientLabTest save(Map<String, Object> map) {
        PatientLabTest labTest = new PatientLabTest();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.convertValue(map, PatientLabTest.class));
//        return testRepository.save(labTest);
        return null;
    }

    public PatientLabTest findTest(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    public List<PatientLabTest> labTests(Long id) {
        return testRepository.findAllByLaboratory_Id(id);
    }

    public List<PatientLabTest> facilityLabTests(Long id) {
        return testRepository.findAllByLaboratory_Department_Facility_Id(id);
    }

}
