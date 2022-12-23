package com.eikal.models.store.shop;

import com.eikal.models.people.User;
import com.eikal.models.store.inventory.ProductFeatures;
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
public class CartItem {

    @Id
    @SequenceGenerator(name = "cart_item_sequence", sequenceName = "cart_item_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_item_sequence")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cart_id")
    private User cart;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ProductFeatures item;
    private int quantity;
    private Timestamp modifiedDate;
}
