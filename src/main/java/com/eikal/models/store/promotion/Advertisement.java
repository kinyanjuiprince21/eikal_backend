package com.eikal.models.store.promotion;

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
public class Advertisement {

    @Id
    @SequenceGenerator(name = "advertisement_sequence", sequenceName = "advertisement_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advertisement_sequence")
    private Long id;
    private String title;

    @Lob
    private String description;
    private Timestamp dateCreated;
    private Timestamp dateToEnd;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String customImageUrl;

}
