package com.eikal.repository.patient;

import com.eikal.models.patient.PatientLabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientLabTestRepository extends JpaRepository<PatientLabTest, Long> {
}
