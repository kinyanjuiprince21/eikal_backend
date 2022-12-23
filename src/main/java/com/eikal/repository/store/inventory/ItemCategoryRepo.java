package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryRepo extends JpaRepository<ItemCategory, Long> {
}
