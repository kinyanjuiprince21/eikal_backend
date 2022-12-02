package com.eikal.repository.patient;

import com.eikal.models.patient.LabStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabStaffRepository extends JpaRepository<LabStaff, Long> {
}
