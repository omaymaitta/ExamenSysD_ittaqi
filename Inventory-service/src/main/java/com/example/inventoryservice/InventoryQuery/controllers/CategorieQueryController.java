package com.example.inventoryservice.InventoryQuery.controllers;

import com.example.commonapi.query.GetAllCategoriesQuery;
import com.example.commonapi.query.GetCategorieById;

import com.example.inventoryservice.InventoryQuery.entities.Categorie;
import com.example.inventoryservice.InventoryQuery.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categorie/queries")
@CrossOrigin("*")
public class CategorieQueryController {
    private QueryGateway queryGateway;
    private CategorieRepository categorieRepository;

    @GetMapping("/allProprietaires")
    public List<Categorie> getAllCategories() {
        return queryGateway.query(new GetAllCategoriesQuery(), ResponseTypes.multipleInstancesOf(Categorie.class)).join();
    }

    @QueryHandler
    public List<Categorie> on(GetAllCategoriesQuery query) {
        return categorieRepository.findAll();
    }

    @GetMapping("/getCategorie/{id}")
    public Categorie getCategorie(@PathVariable String id) {
        return queryGateway.query(new GetCategorieById(id),ResponseTypes.instanceOf(Categorie.class)).join();
    }

    @QueryHandler
    public Categorie on(GetCategorieById query) {
        return categorieRepository.findById(query.getId()).orElse(null);
    }
}
