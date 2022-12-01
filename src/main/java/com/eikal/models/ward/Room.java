package com.eikal.models.ward;

import com.eikal.models.facility.Employee;
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
public class Room extends GeneralType {

    @Id
    @SequenceGenerator(name = "room_sequence", sequenceName = "room_sequence", allocationSize = 1)
    @GeneratedValue(generator = "room_sequence", strategy = GenerationType.AUTO)
    private Long id;

    private String number;
    private Integer capacity;

    @JsonBackReference
    @JsonIgnoreProperties("ward")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    @ToString.Exclude
    private Ward ward;

    @JsonBackReference
    @JsonIgnoreProperties("createdBy")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    @ToString.Exclude
    private Employee createdBy;

    @JsonBackReference
    @JsonIgnoreProperties("modifiedBy")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    @ToString.Exclude
    private Employee modifiedBy;

}
