package com.eikal.repository.patient;

import com.eikal.models.patient.MedicalDiagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalDiagnosisRepository extends JpaRepository<MedicalDiagnosis, Long> {
    List<MedicalDiagnosis> findAllByPatientVisit_Department_Facility_Id(Long facilityId);
    List<MedicalDiagnosis> findAllByPatientVisit_Patient_Id(Long patientId);

}
