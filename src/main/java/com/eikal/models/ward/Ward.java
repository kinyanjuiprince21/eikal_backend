package com.eikal.models.ward;

import com.eikal.models.facility.Employee;
import com.eikal.models.facility.Facility;
import com.eikal.models.facility.GeneralType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Ward extends GeneralType {

    @Id
    @SequenceGenerator(name = "ward_sequence", sequenceName = "ward_sequence", allocationSize = 1)
    @GeneratedValue(generator = "ward_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @JsonIgnoreProperties("facility")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private Facility facility;

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

    private Integer capacity;

}
