package com.eikal.repository.organization;

import com.eikal.models.organization.OrganizationAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationAdminRepository extends JpaRepository<OrganizationAdmin, Long> {
}
