package com.eikal.service.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Facility;
import com.eikal.models.patient.Patient;
import com.eikal.models.patient.PatientType;
import com.eikal.models.people.User;
import com.eikal.repository.patient.PatientRepository;
import com.eikal.service.facility.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {

    ObjectMapper objectMapper = new ObjectMapper();
    private final PatientRepository patientRepository;
    private final EmployeeService employeeService;

    @Autowired
    public PatientService(PatientRepository patientRepository, EmployeeService employeeService) {
        this.patientRepository = patientRepository;
        this.employeeService = employeeService;
    }

    public Patient savePatient(Map<? extends String, Object> map) {
        Employee employee = employeeService.findById(Long.parseLong((String) map.get("createdBy")));

        Patient patient = new Patient();
        patient.setUser(new User(Long.parseLong((String) map.get("user"))));
        patient.setFacility(new Facility(Long.parseLong((String) map.get("facility"))));
        patient.setType(PatientType.valueOf((String) map.get("type")));
        patient.setCreatedBy(employee);
        patient.setModifiedBy(employee);
        patient.setNationalId(Long.valueOf((String) map.get("nationalId")));
        patient.setDateCreated(LocalDateTime.now());
        patient.setDateModified(LocalDateTime.now());
        System.out.println(patient.getUser());
        return patientRepository.save(patient);
    }

    public Patient findPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Page<Patient> findPatientsInFacility(Long facilityId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return patientRepository.findAllByFacility_Id(facilityId, pageable);
    }

}
