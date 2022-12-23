package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepo extends JpaRepository<Price, Long> {
}
