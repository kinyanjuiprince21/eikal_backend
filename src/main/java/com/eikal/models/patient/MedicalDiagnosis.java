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

    private String findings;
    private String prescription;
    private String treatment;
    private String advice;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Employee modifiedBy;
    // TODO: 29/11/2022 findings, prescription, bill, lab

}
