package com.eikal.models.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Laboratory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

@JsonIgnoreProperties(value = {"sentBy", "testedBy", "modifiedBy", "diagnosis", "patientVisit", "laboratory"})
@Entity
public class PatientLabTest {

    @Id
    @SequenceGenerator(name = "lab_test_sequence", sequenceName = "lab_test_sequence", allocationSize = 1)
    @GeneratedValue(generator = "lab_test_sequence", strategy = GenerationType.AUTO)
    private Long id;
    private String testId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patient_visit")
    private PatientVisit patientVisit;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "diagnosis_id")
    private MedicalDiagnosis diagnosis;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tested_by")
    private Employee testedBy;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Employee modifiedBy;

    private String modificationReason = "";
    private LocalDateTime dateTested;
    private LocalDateTime dateModified;
    private String name;
    @Lob
    private String description;
    @Lob
    private String purpose;
    @Lob
    private String results;
    @Lob
    private String conclusion;
    @Lob
    private String recommendation;
    private String specimenSource;
    private String resultUnit;
    private String container;
    private String frequency;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "sent_by")
    private SendTo sentBy;
}
