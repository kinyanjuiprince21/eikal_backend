package com.eikal.repository.patient;

import com.eikal.models.patient.MedicalDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDiagnosisRepository extends JpaRepository<MedicalDiagnosis, Long> {
}
