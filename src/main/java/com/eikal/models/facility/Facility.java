package com.eikal.models.facility;

import com.eikal.models.organization.OrganizationAdmin;
import com.eikal.models.places.ContactInformation;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity
public class Facility {

    @Id
    @SequenceGenerator(name = "facility_sequence", sequenceName = "facility_sequence", allocationSize = 1)
    @GeneratedValue(generator = "facility_sequence", strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private FacilityType type;

    @Enumerated(EnumType.STRING)
    private FacilityLevel level;

    @Enumerated(EnumType.STRING)
    private FacilitySize size;

    @Lob
    private String details;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "contact_information_id")
    private ContactInformation contactInformation;

    @OneToOne
    @JoinColumn(name = "created_by")
    private OrganizationAdmin createdBy;

    @OneToOne
    @JoinColumn(name = "modified_by")
    private OrganizationAdmin modifiedBy;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    public Facility(Long facility) {
        this.id = facility;
    }
}
