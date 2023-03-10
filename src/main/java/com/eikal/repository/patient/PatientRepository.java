package com.eikal.repository.patient;

import com.eikal.models.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByFacility_Id(Long facilityId, Pageable pageable);

}
