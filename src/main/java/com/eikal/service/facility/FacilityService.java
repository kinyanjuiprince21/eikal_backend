package com.eikal.service.facility;

import com.eikal.models.facility.Facility;
import com.eikal.models.facility.FacilityLevel;
import com.eikal.models.facility.FacilitySize;
import com.eikal.models.facility.FacilityType;
import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.places.ContactInformation;
import com.eikal.repository.facility.FacilityRepository;
import com.eikal.repository.organization.OrganizationAdminRepository;
import com.eikal.service.organization.OrganizationAdminService;
import com.eikal.service.people.AppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class FacilityService {

    ObjectMapper objectMapper = new ObjectMapper();

    private final FacilityRepository facilityRepository;
    private final OrganizationAdminService organizationAdminService;

    public FacilityService(FacilityRepository facilityRepository, OrganizationAdminService organizationAdminService) {
        this.facilityRepository = facilityRepository;
        this.organizationAdminService = organizationAdminService;
    }

    public Facility saveFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    public Facility saveFacility(Map<String, Object> facilityMap) {
        Facility facility = objectMapper.convertValue(facilityMap.get("facility"), Facility.class);
        ContactInformation contactInformation = objectMapper.convertValue(facilityMap.get("contactInformation"), ContactInformation.class);
        facility.setContactInformation(contactInformation);
        facility.setCreatedBy(organizationAdminService.getById(Long.valueOf((Integer) facilityMap.get("createdBy"))));
        facility.setDateCreated(LocalDateTime.now());
        facility.setDateModified(LocalDateTime.now());
        return facilityRepository.save(facility);

    }

}
