package com.eikal.models.facility;

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
public class Laboratory extends GeneralType {

    @Id
    @SequenceGenerator(name = "laboratory_sequence", sequenceName = "laboratory_sequence", allocationSize = 1)
    @GeneratedValue(generator = "laboratory_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Employee createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Employee modifiedBy;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    public Laboratory(long id) {
        this.id = id;
    }
}
