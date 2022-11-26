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
public class EmployeeCategory extends GeneralType{

    @Id
    @SequenceGenerator(name = "employee_category_sequence", sequenceName = "employee_category_sequence", allocationSize = 1)
    @GeneratedValue(generator = "employee_category_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private EmployeeGroup group;

    public EmployeeCategory(Long category) {
        this.id = category;
    }
}
