package com.eikal.models.store.shop;

import com.eikal.models.people.User;
import com.eikal.models.places.Address;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
public class Order_ {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long id;

    private int quantity;
    private double orderAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @OneToMany(mappedBy = "order")
    private List<OrderedItem> orderedItems;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    private Timestamp dateOrdered;
    private String code;
    private String status;
}
