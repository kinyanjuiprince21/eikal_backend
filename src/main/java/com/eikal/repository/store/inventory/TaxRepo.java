package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepo extends JpaRepository<Tax, Long> {
}
