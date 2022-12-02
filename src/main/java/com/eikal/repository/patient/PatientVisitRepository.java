package com.eikal.repository.patient;

import com.eikal.models.patient.PatientVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientVisitRepository extends JpaRepository<PatientVisit, Long> {
}
