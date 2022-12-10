package com.eikal.service.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.patient.MedicalDiagnosis;
import com.eikal.models.patient.PatientVisit;
import com.eikal.repository.patient.MedicalDiagnosisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MedicalDiagnosisService {

    private final MedicalDiagnosisRepository diagnosisRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public MedicalDiagnosisService(MedicalDiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    public MedicalDiagnosis saveDiagnosis(Map<String, Object> map) {
        MedicalDiagnosis diagnosis = objectMapper.convertValue(map.get("diagnosis"), MedicalDiagnosis.class);
        diagnosis.setPatientVisit(new PatientVisit(Long.valueOf((String) map.get("patientVisit"))));
        diagnosis.setDoctor(new Employee(Long.parseLong((String) map.get("doctor"))));
        return diagnosisRepository.save(diagnosis);
    }

    public MedicalDiagnosis findDiagnosis(Long id) {
        return diagnosisRepository.findById(id).orElse(null);
    }

    public List<MedicalDiagnosis> getFacilityDiagnosis(Long facilityId) {
        return diagnosisRepository.findAllByPatientVisit_Department_Facility_Id(facilityId);
    }

    public List<MedicalDiagnosis> getPatientDiagnosis(Long patientId) {
        return diagnosisRepository.findAllByPatientVisit_Patient_Id(patientId);
    }

}
