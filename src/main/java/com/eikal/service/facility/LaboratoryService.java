package com.eikal.service.facility;

import com.eikal.models.facility.Laboratory;
import com.eikal.repository.facility.LaboratoryRepository;
import com.eikal.repository.patient.LabStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Laboratory saveLab(Map<String, Object> labMap) {
        Laboratory laboratory = new Laboratory();
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
}