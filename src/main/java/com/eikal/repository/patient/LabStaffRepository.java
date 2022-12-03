package com.eikal.repository.patient;

import com.eikal.models.patient.LabStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabStaffRepository extends JpaRepository<LabStaff, Long> {
    List<LabStaff> findAllByLaboratory_Department_Facility_Id(Long facilityId);
    List<LabStaff> findAllByLaboratory_Id(Long labId);

}
