package com.eikal.repository.patient;

import com.eikal.models.patient.PatientLabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientLabTestRepository extends JpaRepository<PatientLabTest, Long> {
    List<PatientLabTest> findAllByLaboratory_Id(Long id);

    List<PatientLabTest> findAllByLaboratory_Department_Facility_Id(Long id);

}
