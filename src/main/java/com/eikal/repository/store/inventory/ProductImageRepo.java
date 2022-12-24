package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@author David Kinyanjui
 */
public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
}