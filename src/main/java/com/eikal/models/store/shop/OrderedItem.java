package com.eikal.models.store.shop;

import com.eikal.models.store.inventory.Product;
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
public class OrderedItem {

    @Id
    @SequenceGenerator(name = "ordered_item_sequence", sequenceName = "ordered_item_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordered_item_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order_ order;
    private double salePrice;
    private int quantity;
    private Timestamp dateCreated;

}
