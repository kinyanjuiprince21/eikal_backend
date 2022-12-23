package com.eikal.models.store.inventory;

import lombok.*;

import javax.persistence.*;
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
public class Tag {

    @Id
    @SequenceGenerator(name = "tag_sequence", sequenceName = "tag_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence")
    private Long id;
    private String name;

    @Lob
    private String description;

    @ManyToMany(mappedBy = "productTags")
    private List<Product> products;

}
