package com.example.inventoryservice.InventoryQuery.repositories;

import com.example.inventoryservice.InventoryQuery.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
