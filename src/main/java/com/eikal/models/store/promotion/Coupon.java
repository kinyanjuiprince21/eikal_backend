package com.eikal.models.store.promotion;

import com.eikal.models.facility.Facility;
import com.eikal.models.store.inventory.Product;
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
public class Coupon {

    @Id
    @SequenceGenerator(name = "coupon_sequence", sequenceName = "coupon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String type;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

}
