package com.example.customerservice.customerQuery.repositories;

import com.example.customerservice.customerQuery.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Client,String> {

}
