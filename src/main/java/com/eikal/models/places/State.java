package com.eikal.models.places;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class State {

    @Id
    @SequenceGenerator(name = "state_sequence", sequenceName = "state_sequence", allocationSize = 1)
    @GeneratedValue(generator = "state_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private Countries country;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "capital_id")
    private City capital;

}
