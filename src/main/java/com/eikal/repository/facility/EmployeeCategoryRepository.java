package com.eikal.repository.facility;

import com.eikal.models.facility.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategory, Long> {
    List<EmployeeCategory> findAllByGroup_Id(Long groupId);

    List<EmployeeCategory> findAllByGroup_Facility_Id(Long facilityId);

}
