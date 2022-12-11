package com.eikal.service.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Laboratory;
import com.eikal.models.patient.MedicalDiagnosis;
import com.eikal.models.patient.PatientLabTest;
import com.eikal.models.patient.PatientVisit;
import com.eikal.models.patient.SendTo;
import com.eikal.repository.patient.PatientLabTestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PatientLabTestService {

    private final PatientLabTestRepository testRepository;

    @Autowired
    public PatientLabTestService(PatientLabTestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public PatientLabTest save(Map<String, Object> map) {
        PatientLabTest labTest = new PatientLabTest();
        labTest.setPatientVisit(new PatientVisit(Long.valueOf((String) map.get("patientVisit"))));
        labTest.setTestedBy(new Employee(Long.parseLong((String) map.get("testedBy"))));
        labTest.setSentBy(new SendTo(Long.parseLong((String) map.get("sentToId"))));
        labTest.setLaboratory(new Laboratory(Long.parseLong((String) map.get("laboratory"))));
        labTest.setDiagnosis(new MedicalDiagnosis(Long.parseLong((String) map.get("diagnosis"))));
        labTest.setTestId((String) map.get("testId"));
        labTest.setName((String) map.get("name"));
        labTest.setPurpose((String) map.get("purpose"));
        labTest.setResults((String) map.get("results"));
        labTest.setConclusion((String) map.get("conclusion"));
        labTest.setRecommendation((String) map.get("recommendation"));
        labTest.setSpecimenSource((String) map.get("specimenSource"));
        labTest.setResultUnit((String) map.get("resultUnit"));
        labTest.setContainer((String) map.get("container"));
        labTest.setFrequency((String) map.get("frequency"));
        labTest.setCompleted(Boolean.parseBoolean((String) map.get("completed")));
        return testRepository.save(labTest);
    }

    public PatientLabTest findTest(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    public List<PatientLabTest> labTests(Long id) {
        return testRepository.findAllByLaboratory_Id(id);
    }

    public List<PatientLabTest> facilityLabTests(Long id) {
        return testRepository.findAllByLaboratory_Department_Facility_Id(id);
    }

}
