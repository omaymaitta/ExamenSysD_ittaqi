package com.example.customerservice.customerQuery.services;

import com.example.commonapi.events.CustomerCreatedEvent;
import com.example.commonapi.events.CustomerUpdatedEvent;
import com.example.customerservice.customerQuery.entities.Client;
import com.example.customerservice.customerQuery.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceHandler {
    private CustomerRepository  customerRepository;
    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("**************************");
        log.info("CustomerCreatedEvent received");
        customerRepository.save(new Client(event.getId(), event.getNom(), event.getAdresse(), event.getMail(), event.getTele()));
    }

    @EventHandler
    public void on(CustomerUpdatedEvent event){
        log.info("**************************");
        log.info("CustomerUpdatedEvent received");
        Client c = customerRepository.findById(event.getId()).get();
        c.setNom(event.getNom());
        c.setAdresse(event.getAdresse());
        c.setMail(event.getMail());
        c.setTele(event.getTele());
        customerRepository.save(c);
    }
}
