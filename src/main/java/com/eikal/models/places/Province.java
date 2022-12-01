package com.eikal.models.places;

import lombok.*;

import javax.persistence.*;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Province {

    @Id
    @SequenceGenerator(name = "province_sequence", sequenceName = "province_sequence", allocationSize = 1)
    @GeneratedValue(generator = "province_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private Countries country;

}
