package com.eikal.models.patient;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.GeneralType;
import com.eikal.models.facility.Laboratory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Albert Ejuku
 * @version 1.0
 */

@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity
public class LabStaff extends GeneralType {

    @Id
    @SequenceGenerator(name = "lab_staff_sequence", sequenceName = "lab_staff_sequence", allocationSize = 1)
    @GeneratedValue(generator = "labo_staff_sequence", strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "laboratory_id")
    private Laboratory laboratory;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Employee staff;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by_id")
    private Employee modifiedBy;

    private String status;

}
