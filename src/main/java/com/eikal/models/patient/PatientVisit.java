package com.eikal.models.patient;


import com.eikal.models.facility.Department;
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
public class PatientVisit {

    @Id
    @SequenceGenerator(name = "patient_visit_sequence", sequenceName = "patient_visit_sequence", allocationSize = 1)
    @GeneratedValue(generator = "patient_visit_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PatientVisitType visitType = PatientVisitType.OUT_PATIENT;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String cause;

    @Lob
    private String details;

    private boolean billable;
    private boolean billed;
    private boolean discharge;
    private String status;
    private LocalDateTime dateVisited;
    private LocalDateTime dateModified;

    /**
     * <h3>modification reason can be of many types e.g</h3>
     * <ul>
     *     <li>Change visit type from out_patient to in_patient</li>
     *     <li>Change billable status</li>
     *     <li>Visit status change</li>
     *     <li>The patient has been discharged</li>
     * </ul>
     */
    @Lob
    private String modificationReason;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Employee modifiedBy;

}
