package com.eikal.models.facility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity
public class EmployeeDepartment {
    @Id
    @SequenceGenerator(name = "employee_department_sequence", sequenceName = "employee_department_sequence", allocationSize = 1)
    @GeneratedValue(generator = "employee_department_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DepartmentTitle title = DepartmentTitle.MEMBER;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
}
