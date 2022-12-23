package com.eikal.models.store.inventory;

import lombok.*;

import javax.persistence.*;

/**
 * @author Albert Ejuku
 * @version 1.0
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Tax {

    @Id
    @SequenceGenerator(name = "tax_sequence", sequenceName = "tax_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tax_sequence")
    private Long id;

    private String type;
    private double amount;

    @OneToOne(mappedBy = "tax")
    private Product product;
}
