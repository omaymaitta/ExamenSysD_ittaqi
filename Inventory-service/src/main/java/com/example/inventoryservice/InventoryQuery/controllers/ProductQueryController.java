package com.example.inventoryservice.InventoryQuery.controllers;

import com.example.commonapi.query.GetAllProductsQuery;
import com.example.commonapi.query.GetProductById;

import com.example.inventoryservice.InventoryQuery.entities.Product;
import com.example.inventoryservice.InventoryQuery.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product/queries")
@CrossOrigin("*")
public class ProductQueryController {
    private QueryGateway queryGateway;
    private ProductRepository productRepository;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return queryGateway.query(new GetAllProductsQuery(), ResponseTypes.multipleInstancesOf(Product.class)).join();
    }

    @QueryHandler
    public List<Product> on(GetAllProductsQuery query) {
        return productRepository.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable String id) {
        return queryGateway.query(new GetProductById(id),ResponseTypes.instanceOf(Product.class)).join();
    }

    @QueryHandler
    public Product on(GetProductById query) {
        return productRepository.findById(query.getId()).orElse(null);
    }
    
}
