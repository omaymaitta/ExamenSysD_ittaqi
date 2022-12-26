package com.example.inventoryservice.InventoryQuery.service;

import com.example.commonapi.events.CategorieCreatedEvent;
import com.example.commonapi.events.CategorieUpdatedEvent;
import com.example.commonapi.events.ProductCreatedEvent;
import com.example.commonapi.events.ProductUpdatedEvent;
import com.example.inventoryservice.InventoryQuery.entities.Categorie;
import com.example.inventoryservice.InventoryQuery.entities.Product;
import com.example.inventoryservice.InventoryQuery.repositories.CategorieRepository;
import com.example.inventoryservice.InventoryQuery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceHandler {
    private final ProductRepository productRepository;
    private final CategorieRepository categorieRepository;

    @EventHandler
    public void on(CategorieCreatedEvent event) {

        log.info("CategorieCreatedEvent received");
        Categorie categorie = new Categorie();
        categorie.setId(event.getId());
        categorie.setNom(event.getNom());
        categorie.setDescription(event.getDescription());
        categorieRepository.save(categorie);
    }

    @EventHandler
    public void on(CategorieUpdatedEvent event) {

        log.info("CategorieUpdatedEvent received");
        Categorie Categorie = categorieRepository.findById(event.getId()).get();
        Categorie.setNom(event.getNom());
        Categorie.setDescription(event.getDescription());
        categorieRepository.save(Categorie);
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        log.info("*********************************");
        log.info("ProductCreatedEvent received");
        Product Product = new Product();
        Product.setId(event.getId());
        Product.setNom(event.getNom());
        Product.setPrix(event.getPrix());
        Product.setEtat(event.getEtat());
        Product.setQuantiteStock(event.getQuantiteStock());
        Categorie Categorie = categorieRepository.findById(event.getCategorie()).get();
        if (Categorie != null) {
            Product.setCategorie(Categorie);
        }
        productRepository.save(Product);
    }

    @EventHandler
    public void on(ProductUpdatedEvent event) {
        log.info("*********************************");
        log.info("ProductUpdatedEvent received");
        Product Product = productRepository.findById(event.getId()).get();
        Product.setNom(event.getNom());
        Product.setPrix(event.getPrix());
        Product.setQuantiteStock(event.getQuantiteStock());
        Product.setEtat(event.getEtat());
        Categorie Categorie = categorieRepository.findById(event.getCategorie()).get();
        Product.setCategorie(Categorie);
        productRepository.save(Product);
    }
}
