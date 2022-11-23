package com.eikal.service.organization;

import com.eikal.models.organization.Organization;
import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.organization.OrganizationType;
import com.eikal.models.people.AppUser;
import com.eikal.repository.organization.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationAdminService organizationAdminService;

    @Autowired
    public OrganizationService(OrganizationRepository repository, OrganizationAdminService organizationAdminService) {
        this.organizationRepository = repository;
        this.organizationAdminService = organizationAdminService;
    }

    public Organization saveOrg(Organization organization) {
        if(organization.getType() == null) {
            throw new IllegalStateException("You did not specify the org type");
//            organization.setType(OrganizationType.HOSPITAL);
        }
        organization.setDateCreated(LocalDateTime.now());
        organization.setDateModified(LocalDateTime.now());
        return organizationRepository.save(organization);
    }

    @Transactional
    public Organization saveOrg(Organization organization, OrganizationAdmin organizationAdmin, AppUser appUser) {
        Organization savedOrg = saveOrg(organization);
        organizationAdmin.setCreated(true);
        organizationAdmin.setOrganization(savedOrg);
        if(organizationAdminService.saveOrgAdmin(organizationAdmin, appUser) != null){
            System.out.println("This admin was created successfully.");
        }
        return savedOrg;
    }

    public Organization updateOrg(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization getOrg(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }


}

