package com.eikal.service.patient;

import com.eikal.repository.patient.PatientVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientVisitService {

    private final PatientVisitRepository visitRepository;

    @Autowired
    public PatientVisitService(PatientVisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }


}
