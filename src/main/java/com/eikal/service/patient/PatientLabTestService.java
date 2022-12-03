package com.eikal.service.patient;

import com.eikal.repository.patient.PatientLabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientLabTestService {

    private final PatientLabTestRepository testRepository;

    @Autowired
    public PatientLabTestService(PatientLabTestRepository testRepository) {
        this.testRepository = testRepository;
    }
}
