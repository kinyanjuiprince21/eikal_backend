package com.eikal.repository.facility;

import com.eikal.models.facility.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByFacility_Id(Long facilityId);

}
