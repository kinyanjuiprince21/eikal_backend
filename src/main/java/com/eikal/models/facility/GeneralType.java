package com.eikal.models.facility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

@MappedSuperclass
public class GeneralType {
    private String name;
    @Lob
    private String details;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateModified;
}
