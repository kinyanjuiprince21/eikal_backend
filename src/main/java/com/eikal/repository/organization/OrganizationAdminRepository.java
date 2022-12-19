package com.eikal.repository.organization;

import com.eikal.models.organization.OrganizationAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface OrganizationAdminRepository extends JpaRepository<OrganizationAdmin, Long> {
    OrganizationAdmin findByAppUser_Id(Long userId);

}
