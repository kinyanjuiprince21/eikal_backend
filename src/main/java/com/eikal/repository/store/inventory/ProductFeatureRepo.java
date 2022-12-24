package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.ProductFeatures;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@author David Kinyanjui
 */
public interface ProductFeatureRepo extends JpaRepository<ProductFeatures, Long> {
}
