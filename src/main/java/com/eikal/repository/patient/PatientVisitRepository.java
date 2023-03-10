package com.eikal.repository.patient;

import com.eikal.models.patient.PatientVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientVisitRepository extends JpaRepository<PatientVisit, Long> {
    List<PatientVisit> findAllByPatient_Id(Long id);
    List<PatientVisit> findAllByDepartment_Facility_Id(Long id);

}
