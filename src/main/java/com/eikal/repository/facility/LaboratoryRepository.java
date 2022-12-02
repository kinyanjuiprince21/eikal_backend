package com.eikal.repository.facility;

import com.eikal.models.facility.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
    List<Laboratory> findAllByDepartment_Facility_Id(Long facilityId);
    List<Laboratory> findAllByDepartment_Id(Long depId);

}
