package com.example.commonapi.events;

import com.example.commonapi.Enums.EnumState;
import lombok.Getter;

@Getter
public class ProductUpdatedEvent extends BaseEvent<String> {
    private String nom;
    private double prix;
    private double quantiteStock;
    private EnumState etat;
    private String categorie;


    public ProductUpdatedEvent(String id, String nom, double prix, double quantiteStock, EnumState etat, String categorie) {

        super(id);
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.etat = etat;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public double getQuantiteStock() {
        return quantiteStock;
    }

    public EnumState getEtat() {
        return etat;
    }

    public String getCategorie() {
        return categorie;
    }
}
