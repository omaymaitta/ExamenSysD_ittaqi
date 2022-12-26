package com.example.customerservice.customerQuery.controllers;


import com.example.commonapi.query.GetAllClientsQuery;
import com.example.commonapi.query.GetClientById;
import com.example.customerservice.customerQuery.entities.Client;
import com.example.customerservice.customerQuery.repositories.CustomerRepository;

import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/queries")
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerQueryController {

    private QueryGateway queryGateway;
    private CustomerRepository customerRepository;

    @GetMapping("/getAllClients")
    public List<Client> getAllClients(){
        return queryGateway.query(new GetAllClientsQuery(),
                ResponseTypes.multipleInstancesOf(Client.class)).join();
    }

    @QueryHandler
    public List<Client> on(GetAllClientsQuery query){
        return customerRepository.findAll();
    }

    @GetMapping("/getClient/{id}")
    public Client getClient(@PathVariable String id){
        return queryGateway.query(new GetClientById(id),
                ResponseTypes.instanceOf(Client.class)).join();
    }

    @QueryHandler
    public Client on(GetClientById query){
        return customerRepository.findById(query
                .getId()).get();
    }
}
