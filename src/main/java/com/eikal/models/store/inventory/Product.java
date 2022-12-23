package com.eikal.models.store.inventory;

import com.eikal.models.facility.Facility;
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
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;

    private String name;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory category;

    private String itemCode;

    @OneToMany(mappedBy = "product")
    private List<ProductFeatures> productFeatures;

    @ManyToMany
    @JoinTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> productTags;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_id")
    private Tax tax;
    private Timestamp dateModified;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Facility vendor;
    private String manufacturer;

}
