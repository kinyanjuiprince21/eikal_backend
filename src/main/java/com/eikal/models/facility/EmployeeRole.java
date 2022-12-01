package com.eikal.models.facility;

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
public class EmployeeRole {

    @Id
    @SequenceGenerator(name = "employee_role_sequence", sequenceName = "employee_role_sequence", allocationSize = 1)
    @GeneratedValue(generator = "employee_role_sequence", strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private boolean isActive;

}

