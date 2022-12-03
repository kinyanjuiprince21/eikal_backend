package com.eikal.service.patient;

import com.eikal.repository.patient.MedicalDiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalDiagnosisService {

    private final MedicalDiagnosisRepository diagnosisRepository;

    @Autowired
    public MedicalDiagnosisService(MedicalDiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }


}
