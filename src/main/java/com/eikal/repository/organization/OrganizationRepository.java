package com.eikal.repository.organization;

import com.eikal.models.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
