package com.eikal.models.places;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class City {

    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1)
    @GeneratedValue(generator = "city_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String name;
    private boolean capital;

    @Enumerated(EnumType.STRING)
    private Countries country;

    @Column(length = 100)
    private String region;

    @Lob
    private String description;

}
