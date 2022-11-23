package com.eikal.repository.places;

import com.eikal.models.places.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseDAO  extends JpaRepository<Warehouse, Long> {
}
