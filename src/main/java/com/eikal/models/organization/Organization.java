package com.eikal.models.organization;

import com.eikal.models.places.Address;
import com.eikal.models.places.ContactInformation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Organization {

    @Id
    @SequenceGenerator(sequenceName = "organization_sequence", name = "organization_sequence", allocationSize = 1)
    @GeneratedValue(generator = "organization_sequence", strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String details;
    private OrganizationType type;

    @OneToOne
    @JoinColumn(name = "created_by")
    private OrganizationAdmin createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private OrganizationAdmin modifiedBy;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private ContactInformation contact;

}

// create organization
// create admin with organization code
// assign organization created by admin