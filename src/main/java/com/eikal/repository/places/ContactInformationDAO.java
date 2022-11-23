package com.eikal.repository.places;

import com.eikal.models.places.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationDAO extends JpaRepository<ContactInformation, Long> {
}
