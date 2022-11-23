package com.eikal.models.people;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@MappedSuperclass
public class Person {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

}
