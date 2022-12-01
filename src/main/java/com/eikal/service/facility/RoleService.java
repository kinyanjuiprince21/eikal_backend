package com.eikal.service.facility;

import com.eikal.models.facility.Facility;
import com.eikal.models.facility.Role;
import com.eikal.repository.facility.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Service
public class RoleService {

    ObjectMapper objectMapper = new ObjectMapper();
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Map<String, Object> roleMap) {
        Role role = objectMapper.convertValue(roleMap.get("role"), Role.class);
        role.setFacility(new Facility(Long.valueOf((Integer) roleMap.get("facility"))));
        role.setDateCreated(LocalDateTime.now());
        role.setDateModified(LocalDateTime.now());
        return roleRepository.save(role);
    }

    public Role findRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> findAllRolesInFacility(Long facilityId) {
        return roleRepository.findAllByFacility_Id(facilityId);
    }

}
