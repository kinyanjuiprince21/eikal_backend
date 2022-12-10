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
public class SendTo {

    @Id
    @SequenceGenerator(name = "send_to_sequence", sequenceName = "send_to_sequence", allocationSize = 1)
    @GeneratedValue(generator = "sent_to_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Employee receiver;

    @ManyToOne
    @JoinColumn(name = "received_by")
    private Employee receivedBy;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private PatientVisit visit;

    private String reason;

    @Lob
    private String details;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Employee sender;
    private String from_;
    private String type; // one of many types e.g diagnosis, visit, test, pharmacy, surgery e.t.c
    private Long code; // pk of type
    private boolean sent;
    private boolean received;
    private LocalDateTime dateSent;
    private LocalDateTime dateReceived;
}
