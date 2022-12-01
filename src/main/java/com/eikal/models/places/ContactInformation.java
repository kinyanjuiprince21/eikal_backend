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
public class ContactInformation {

    @Id
    @SequenceGenerator(name = "contact_info_sequence", sequenceName = "contact_info_sequence", allocationSize = 1)
    @GeneratedValue(generator = "contact_info_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 13)
    private String phone;

    @Column(length = 100)
    private String type;

    private String website;

    @Column(length = 100)
    private String code;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
