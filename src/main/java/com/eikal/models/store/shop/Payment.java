package com.eikal.models.store.shop;

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
public class Payment {

    @Id
    @SequenceGenerator(name = "payment_sequence", sequenceName = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order_ order;
    private String mode;

    @Lob
    private String description;
    private String status;
    private String amount;
    private Timestamp dateModified;

}
