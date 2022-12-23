package com.eikal.repository.store.inventory;

import com.eikal.models.store.inventory.ItemCategory;
import com.eikal.models.store.inventory.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
