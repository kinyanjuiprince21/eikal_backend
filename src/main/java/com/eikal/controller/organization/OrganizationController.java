package com.eikal.controller.organization;

import com.eikal.models.organization.Organization;
import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.people.AppUser;
import com.eikal.service.organization.OrganizationService;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("organization")
public class OrganizationController {

    private final OrganizationService organizationService;
    private final ObjectMapper objectMapper;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
        this.objectMapper = new ObjectMapper();
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

    @PostMapping("process")
    public void process(@RequestBody Collection<? extends Map<String, Object>> payload) {

        System.out.println(payload);

    }

}
