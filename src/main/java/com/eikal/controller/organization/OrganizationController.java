package com.eikal.controller.organization;

import com.eikal.models.organization.Organization;
import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.people.AppUser;
import com.eikal.service.organization.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
@RequestMapping("organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveOrganization(@RequestPart("organization") Organization organization, @RequestPart("organizationAdmin") OrganizationAdmin organizationAdmin, @RequestPart("appUser") AppUser appUser) {
        Organization saveOrg = organizationService.saveOrg(organization, organizationAdmin, appUser);
        return ResponseEntity.status(201).body(saveOrg);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOrganization(@PathVariable Long id) {
        Organization organization = organizationService.getOrg(id);
        if (organization == null) {
            return ResponseEntity.status(404).body("No organization was found");
        }
        return ResponseEntity.status(200).body(organization);
    }

}
