package com.eikal.models.organization;

import com.eikal.models.people.AppUser;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

@Entity
public class OrganizationAdmin {
    // when creating this admin, their respective user profile should be created.

    @Id
    @SequenceGenerator(sequenceName = "org_admin_sequence", name = "org_admin_sequence", allocationSize = 1)
    @GeneratedValue(generator = "org_admin_sequence", strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private String status;

    @OneToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private OrganizationAdmin createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private OrganizationAdmin modifiedBy;

    private boolean created = false;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
