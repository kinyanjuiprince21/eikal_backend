package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@author David Kinyanjui
 */
public interface ItemCategoryRepo extends JpaRepository<ItemCategory, Long> {
}
