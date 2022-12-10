package com.eikal.models.patient;

import com.eikal.models.facility.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity
public class MedicalDiagnosis {

    @Id
    @SequenceGenerator(name = "medical_diagnosis_sequence", sequenceName = "medical_diagnosis_sequence", allocationSize = 1)
    @GeneratedValue(generator = "medical_diagnosis_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_visit")
    private PatientVisit patientVisit;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Employee doctor;
    @Lob
    private String symptoms;
    @Lob
    private String medicalHistory;
    @Lob
    private String currentMedications;
    @Lob
    private String allergies;
    @Lob
    private String lifestyle;
    @Lob
    private String habits;
    @Lob
    private String physicalExamination;
    @Lob
    private String physicalExaminationFindings;
    @Lob
    private String findings;
    @Lob
    private String prescription;
    @Lob
    private String treatment;
    @Lob
    private String advice;
    private boolean recommendTest;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private String modifyReason; // can be of type:-> test results, different result e.t.c

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Employee modifiedBy;
    // TODO: 29/11/2022 findings, prescription, bill, lab

}
