package com.example.inventoryservice.InventoryQuery.repositories;

import com.example.inventoryservice.InventoryQuery.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, String> {
}
