package com.eikal.repository.facility;

import com.eikal.models.facility.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByFacility_Id(Long facilityId);

}
