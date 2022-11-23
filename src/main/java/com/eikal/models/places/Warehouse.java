package com.eikal.models.places;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Warehouse {

    @Id
    @SequenceGenerator(name = "warehouse_sequence", sequenceName = "warehouse_sequence", allocationSize = 1)
    @GeneratedValue(generator = "warehouse_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}

// TODO: 5/3/22