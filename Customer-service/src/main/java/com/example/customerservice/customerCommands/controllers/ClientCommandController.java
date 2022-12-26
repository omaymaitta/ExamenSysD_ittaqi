package com.example.customerservice.customerCommands.controllers;


import com.example.commonapi.commands.CreateCustomerCommand;
import com.example.commonapi.commands.UpdateCustomerCommand;
import com.example.commonapi.dtos.CreateClientRequestDTO;
import com.example.commonapi.dtos.UpdateClientRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/client/commands")

@CrossOrigin("*")
public class ClientCommandController {

    private CommandGateway commandGateway;

    private EventStore eventStore;

    public ClientCommandController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/createClient")
    public CompletableFuture<String> createClient(@RequestBody CreateClientRequestDTO request) {
        return commandGateway.send(new CreateCustomerCommand(UUID.randomUUID().toString(),
                request.getNom(),request.getAdresse(),request.getMail(),request.getTele()));
    }

    @PutMapping("/updateClient")
    public CompletableFuture<String> updateClient(@RequestBody UpdateClientRequestDTO request) {
        return commandGateway.send(new UpdateCustomerCommand(request.getId(),
                request.getNom(),request.getAdresse(),request.getMail(),request.getTele()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{clientId}")
    public Stream getEventsForAccount(@PathVariable(value = "clientId") String clientId) {
        return eventStore.readEvents(clientId).asStream();
    }

}
