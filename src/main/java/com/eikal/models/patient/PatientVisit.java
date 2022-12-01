package com.eikal.models.patient;


import com.eikal.models.facility.Department;
import com.eikal.models.facility.Employee;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import java.time.LocalDateTime;


/**
 * @author Albert Ejuku
 * @version 1.0
 */
public class PatientVisit {
    private Long id;

    @Enumerated(EnumType.STRING)
    private PatientVisitType visitType = PatientVisitType.OUT_PATIENT;
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
    private Employee createdBy;
    private Employee modifiedBy;

}
