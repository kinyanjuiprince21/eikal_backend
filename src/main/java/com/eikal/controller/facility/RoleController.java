package com.eikal.controller.facility;

import com.eikal.models.facility.Role;
import com.eikal.service.facility.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping("role/save")
    public ResponseEntity<?> saveRole(@RequestBody Map<String, Object> roleMap) {
        Role savedRole = roleService.saveRole(roleMap);
        if(savedRole != null) {
            return ResponseEntity.status(201).body(savedRole);
        }
        return ResponseEntity.status(415).build();
    }

    @GetMapping("role/{id}")
    public ResponseEntity<?> findRole(@PathVariable Long id) {
        Role role = roleService.findRoleById(id);
        if(role != null) {
            return ResponseEntity.status(200).body(role);
        }
        return ResponseEntity.status(404).body("Role not found");
    }

    @GetMapping("roles")
    public ResponseEntity<?> findRolesInFacility(@RequestParam Long facilityId) {
        List<Role> roles = roleService.findAllRolesInFacility(facilityId);
        if(!roles.isEmpty()) {
            return ResponseEntity.status(200).body(roles);
        }
        return ResponseEntity.status(404).body("No role found in this facility");
    }
}
