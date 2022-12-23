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
public class ItemCategory {

    @Id
    @SequenceGenerator(name = "item_category_sequence", sequenceName = "item_category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_category_sequence")
    private Long id;

    @Column(unique = true)
    private String name;

    @Lob
    private String description;
    private Timestamp dateModified;
}
