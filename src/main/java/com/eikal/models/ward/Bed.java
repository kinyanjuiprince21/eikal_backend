package com.eikal.models.ward;

import com.eikal.models.facility.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

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
public class Bed {

    @Id
    @SequenceGenerator(name = "bed_sequence", sequenceName = "bed_sequence", allocationSize = 1)
    @GeneratedValue(generator = "bed_sequence", strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @Lob
    private String details;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    @JsonBackReference
    @JsonIgnoreProperties("createdBy")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Employee createdBy;

    @JsonBackReference
    @JsonIgnoreProperties("modifiedBy")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    private Employee modifiedBy;


    @ManyToOne()
    @JoinColumn(name = "room_id")
    private Room room;

    @Enumerated(EnumType.STRING)
    private BedStatus status = BedStatus.OPEN;
}
