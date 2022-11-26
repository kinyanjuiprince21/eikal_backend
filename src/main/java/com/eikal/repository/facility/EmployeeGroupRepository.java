package com.eikal.repository.facility;

import com.eikal.models.facility.EmployeeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeGroupRepository extends JpaRepository<EmployeeGroup, Long> {
    List<EmployeeGroup> findAllByFacility_Id(Long facilityId);

}
