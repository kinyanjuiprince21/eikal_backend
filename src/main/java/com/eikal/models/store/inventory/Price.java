package com.eikal.models.store.inventory;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

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
public class Price {

    @Id
    @SequenceGenerator(name = "price_sequence", sequenceName = "price_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_sequence")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "product_feature")
    private ProductFeatures productFeature;

    private double buyPrice;
    private double salePrice;
    private String currency;
    private double discount;
    private Timestamp dateModified;
}
