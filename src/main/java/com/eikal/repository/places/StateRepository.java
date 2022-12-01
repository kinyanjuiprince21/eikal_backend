package com.eikal.repository.places;

import com.eikal.models.places.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Albert Ejuku
 * @version 1.0
 */
@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
