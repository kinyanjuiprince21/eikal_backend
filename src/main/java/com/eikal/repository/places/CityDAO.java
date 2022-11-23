package com.eikal.repository.places;

import com.eikal.models.places.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDAO extends JpaRepository<City, Long> {
}
