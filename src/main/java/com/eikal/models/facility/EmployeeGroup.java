package com.eikal.models.facility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity
public class EmployeeGroup extends GeneralType {

    @Id
    @SequenceGenerator(name = "employee_group_sequence", sequenceName = "employee_group_sequence", allocationSize = 1)
    @GeneratedValue(generator = "employee_group_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    public EmployeeGroup(Long group) {
        this.id = group;
    }
}
