package com.eikal.service.patient;

import com.eikal.models.patient.MedicalDiagnosis;
import com.eikal.repository.patient.MedicalDiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MedicalDiagnosisService {

    private final MedicalDiagnosisRepository diagnosisRepository;

    @Autowired
    public MedicalDiagnosisService(MedicalDiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    public MedicalDiagnosis saveDiagnosis(Map<String, Object> map) {
        MedicalDiagnosis medicalDaiagnosis = new MedicalDiagnosis();
        return diagnosisRepository.save(medicalDaiagnosis);
    }

}
