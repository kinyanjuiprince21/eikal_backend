package com.eikal.models.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Laboratory;

import java.time.LocalDateTime;

/**
 * @author <i style='color: #aaccee; background-color:#ca7945; font-weight: bold; padding: 10px 20px; border-radius: 7px;'>Albert Ejuku</i>
 * @version 1.0
 */

public class PatientLabTest {
    private Long id;
    private String testId;
    private PatientVisit patientVisit;
    private Employee testedBy;
    private Employee modifiedBy;
    private String modificationReason = "";
    private LocalDateTime dateTested;
    private LocalDateTime dateModified;
    private String name;
    private String description;
    private String purpose;
    private String results;
    private String conclusion;
    private String specimenSource;
    private String resultUnit;
    private String container;
    private String frequency;
    private Laboratory laboratory;
    private boolean completed;
}
