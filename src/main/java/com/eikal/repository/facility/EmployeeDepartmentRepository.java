package com.eikal.repository.facility;

import com.eikal.models.facility.EmployeeDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, Long> {
    List<EmployeeDepartment> findAllByDepartment_Id(Long depId);
    List<EmployeeDepartment> findAllByEmployee_Id(Long empId);

}
