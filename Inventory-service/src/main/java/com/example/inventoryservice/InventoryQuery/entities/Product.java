package com.example.inventoryservice.InventoryQuery.entities;

import com.example.inventoryservice.InventoryQuery.Enums.EnumState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String nom;
    private double prix;
    private double quantiteStock;
    private EnumState etat;
    @ManyToOne
    private Categorie categorie;

    public void setEtat(com.example.commonapi.Enums.EnumState etat) {
    }
}
