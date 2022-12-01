package com.eikal.models.patient;

import com.eikal.models.facility.Employee;

import java.time.LocalDateTime;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
public class SentToDoctor {
    private Long id;
    private Employee doctor;
    private PatientVisit visit;
    private String reason;
    private Employee sentBy;
    private boolean sent;
    private boolean received;
    private LocalDateTime dateSent;
}
