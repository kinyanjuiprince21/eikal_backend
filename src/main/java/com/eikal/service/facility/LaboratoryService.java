package com.eikal.service.facility;

import com.eikal.models.facility.Department;
import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Laboratory;
import com.eikal.models.patient.LabStaff;
import com.eikal.models.patient.Patient;
import com.eikal.repository.facility.LaboratoryRepository;
import com.eikal.repository.patient.LabStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class LaboratoryService {

    private final LaboratoryRepository labRepository;
    private final LabStaffRepository labStaffRepository;

    @Autowired
    public LaboratoryService(LaboratoryRepository labRepository, LabStaffRepository labStaffRepository) {
        this.labRepository = labRepository;
        this.labStaffRepository = labStaffRepository;
    }

    public Laboratory saveLab(Map<String, Object> map) {
        Laboratory laboratory = new Laboratory();
        laboratory.setName((String) map.get("name"));
        laboratory.setDetails((String) map.get("details"));
        laboratory.setCreatedBy(new Employee(Long.parseLong((String) map.get("createdBy"))));
        laboratory.setModifiedBy(new Employee(Long.parseLong((String) map.get("createdBy"))));
        laboratory.setDepartment(new Department(Long.parseLong((String) map.get("department"))));
        laboratory.setDateCreated(LocalDateTime.now());
        laboratory.setDateModified(LocalDateTime.now());
        return labRepository.save(laboratory);
    }

    public Laboratory findLab(Long id) {
        return labRepository.findById(id).orElse(null);
    }

    public List<Laboratory> findLabsInFacility(Long facilityId) {
        return labRepository.findAllByDepartment_Facility_Id(facilityId);
    }

    public List<Laboratory> findLabsInDepartment(Long depId) {
        return labRepository.findAllByDepartment_Id(depId);
    }

    public LabStaff saveLabStaff(Map<String, Object> map) {
        LabStaff labStaff = new LabStaff();
        labStaff.setName((String) map.get("name"));
        labStaff.setDetails((String) map.get("details"));
        labStaff.setTitle((String) map.get("title"));
        labStaff.setStatus((String) map.get("status"));
        labStaff.setCreatedBy(new Employee(Long.parseLong((String) map.get("createdBy"))));
        labStaff.setModifiedBy(new Employee(Long.parseLong((String) map.get("createdBy"))));
        labStaff.setLaboratory(new Laboratory(Long.parseLong((String) map.get("laboratory"))));
        labStaff.setStaff(new Employee(Long.parseLong((String) map.get("staff"))));
        labStaff.setDateCreated(LocalDateTime.now());
        labStaff.setDateModified(LocalDateTime.now());
        return labStaffRepository.save(labStaff);
    }

    public LabStaff findLabStaff(Long id) {
        return labStaffRepository.findById(id).orElse(null);
    }

    public List<LabStaff> findStaffInLab(Long labId){
        return labStaffRepository.findAllByLaboratory_Id(labId);
    }

    public List<LabStaff> findStaffInFacility(Long facilityId) {
        return labStaffRepository.findAllByLaboratory_Department_Facility_Id(facilityId);
    }
}
