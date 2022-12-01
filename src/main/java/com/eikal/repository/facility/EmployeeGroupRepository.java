package com.eikal.repository.facility;

import com.eikal.models.facility.EmployeeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface EmployeeGroupRepository extends JpaRepository<EmployeeGroup, Long> {
    List<EmployeeGroup> findAllByFacility_Id(Long facilityId);

}
