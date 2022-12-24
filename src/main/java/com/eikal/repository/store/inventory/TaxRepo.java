package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@author David Kinyanjui
 */
public interface TaxRepo extends JpaRepository<Tax, Long> {
}
