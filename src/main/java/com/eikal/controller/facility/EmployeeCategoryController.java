package com.eikal.controller.facility;

import com.eikal.models.facility.EmployeeCategory;
import com.eikal.models.facility.EmployeeGroup;
import com.eikal.service.facility.EmployeeCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@RestController
public class EmployeeCategoryController {

    private final EmployeeCategoryService employeeCategoryService;

    public EmployeeCategoryController(EmployeeCategoryService employeeCategoryService) {
        this.employeeCategoryService = employeeCategoryService;
    }

    @PostMapping("category/save")
    public ResponseEntity<?> saveCategory(@RequestBody Map<String, Object> category) {
        EmployeeCategory saveCategory =  employeeCategoryService.saveCategory(category);
        if(saveCategory != null) {
            return ResponseEntity.status(201).body(saveCategory);
        }
        return ResponseEntity.status(415).build();
    }

    @GetMapping("category/{id}")
    public ResponseEntity<?> findCategory(@PathVariable Long id) {
        EmployeeCategory category = employeeCategoryService.findCategoryById(id);
        if(category != null) {
            return ResponseEntity.status(200).body(category);
        }
        return ResponseEntity.status(404).body("did not found category");
    }

    @GetMapping(value = {"categories/search", "categories"})
    public ResponseEntity<?> findCategoriesInGroup(@RequestParam(required = false) Long group, @RequestParam(required = false) Long facility) {
        List<EmployeeCategory> employeeCategories;
        if(group != null) {
            employeeCategories = employeeCategoryService.findCategoriesInGroup(group);
            if(employeeCategories != null) {
                return ResponseEntity.status(200).body(employeeCategories);
            } else {
                return ResponseEntity.status(404).body("No categories in this group");
            }
        }
        if(facility != null) {
            employeeCategories = employeeCategoryService.findCategoriesInFacility(facility);
            if(employeeCategories != null) {
                return ResponseEntity.status(200).body(employeeCategories);
            } else {
                return ResponseEntity.status(404).body("No categories in this facility");
            }
        }

        return ResponseEntity.status(404).body("Unknown request");
    }

    @PostMapping("group/save")
    public ResponseEntity<?> saveGroup(@RequestBody Map<String, Object> group) {
        EmployeeGroup savedGroup =  employeeCategoryService.saveGroup(group);
        if(savedGroup != null) {
            return ResponseEntity.status(201).body(savedGroup);
        }
        return ResponseEntity.status(415).build();
    }

    @GetMapping("group/{id}")
    public ResponseEntity<?> findGroup(@PathVariable Long id) {
        EmployeeGroup group = employeeCategoryService.findGroupById(id);
        if(group != null) {
            return ResponseEntity.status(200).body(group);
        }
        return ResponseEntity.status(404).body("Group not found");
    }

    @GetMapping("group/facility")
    public ResponseEntity<?> findGroupsInFacility(@RequestParam("id") Long id) {
        List<EmployeeGroup> groups = employeeCategoryService.findGroupsInFacility(id);
        if(groups.isEmpty()) {
            return ResponseEntity.status(404).body("This facility has no group");
        }
        return ResponseEntity.status(200).body(groups);
    }

}