package com.eikal.repository.places;

import com.eikal.models.places.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Long> {
}
