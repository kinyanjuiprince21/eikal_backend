package com.eikal.models.facility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author albert ejuku
 * @version 1.0
 */
@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity
public class Department extends GeneralType{

    @Id
    @SequenceGenerator(name = "department_sequence", sequenceName = "department_sequence", allocationSize = 1)
    @GeneratedValue(generator = "department_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Employee modifiedBy;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
}
