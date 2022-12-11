package com.eikal.models.people;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Relationship {

    @Id
    @SequenceGenerator(name = "relationship_sequence", sequenceName = "relationship_sequence", allocationSize = 1)
    @GeneratedValue(generator = "relationship_sequence", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    @Enumerated(EnumType.STRING)
    private RelationshipType type = RelationshipType.OTHER;
    private String details;
    private Long isNextOfKinOf = (long) -1;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

}
