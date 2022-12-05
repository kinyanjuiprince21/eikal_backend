package com.eikal.service.patient;

import com.eikal.models.patient.PatientVisit;
import com.eikal.repository.patient.PatientVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PatientVisitService {

    private final PatientVisitRepository visitRepository;

    @Autowired
    public PatientVisitService(PatientVisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public PatientVisit saveVisit(Map<String, Object> map) {
        PatientVisit patientVisit = new PatientVisit();
        return visitRepository.save(patientVisit);
    }

    public PatientVisit findVisit(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    public List<PatientVisit> findVisitsByPatient(Long id) {
        return visitRepository.findAllByPatient_Id(id);
    }

    public List<PatientVisit> findVisitsByFacility(Long id) {
        return visitRepository.findAllByDepartment_Facility_Id(id);
    }

    public List<PatientVisit> findAllVisits(int page, int size) {
        return visitRepository.findAll();
    }

}
