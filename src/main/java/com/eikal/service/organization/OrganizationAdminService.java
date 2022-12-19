package com.eikal.service.organization;

import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.people.AppUser;
import com.eikal.repository.organization.OrganizationAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Service
public class OrganizationAdminService {

    private final OrganizationAdminRepository orgAdminRepo;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public OrganizationAdminService(OrganizationAdminRepository orgAdminRepo) {
        this.orgAdminRepo = orgAdminRepo;
    }

    public OrganizationAdmin saveOrgAdmin(OrganizationAdmin organizationAdmin, AppUser appUser) {
        organizationAdmin.setDateCreated(LocalDateTime.now());
        organizationAdmin.setDateModified(LocalDateTime.now());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        organizationAdmin.setAppUser(appUser);
        return orgAdminRepo.save(organizationAdmin);
    }

    public OrganizationAdmin getById(Long id) {
        return orgAdminRepo.findById(id).orElse(null);
    }

    public OrganizationAdmin findByUser(Long userId) {
        return orgAdminRepo.findByAppUser_Id(userId);
    }
}
