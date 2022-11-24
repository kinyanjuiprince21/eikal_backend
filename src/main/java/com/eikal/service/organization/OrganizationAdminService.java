package com.eikal.service.organization;

import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.people.AppUser;
import com.eikal.repository.organization.OrganizationAdminRepository;
import com.eikal.repository.organization.OrganizationRepository;
import com.eikal.service.people.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrganizationAdminService {

    private final OrganizationAdminRepository orgAdminRepo;
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public OrganizationAdminService(OrganizationAdminRepository orgAdminRepo, AppUserService appUserService) {
        this.orgAdminRepo = orgAdminRepo;
        this.appUserService = appUserService;
    }

    public OrganizationAdmin saveOrgAdmin(OrganizationAdmin organizationAdmin, AppUser appUser) {
        organizationAdmin.setDateCreated(LocalDateTime.now());
        organizationAdmin.setDateModified(LocalDateTime.now());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        organizationAdmin.setAppUser(appUser);
        return orgAdminRepo.save(organizationAdmin);
    }

}
