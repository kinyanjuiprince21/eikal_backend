package com.eikal.repository.facility;

import com.eikal.models.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {

}
