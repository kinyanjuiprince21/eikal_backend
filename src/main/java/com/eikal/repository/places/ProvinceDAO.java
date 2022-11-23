package com.eikal.repository.places;

import com.eikal.models.places.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceDAO extends JpaRepository<Province, Long> {
}
