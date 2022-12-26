package com.example.inventoryservice.InventoryCommands.controllers;

import com.example.commonapi.commands.CreateCategorieCommand;
import com.example.commonapi.commands.UpdateCategorieCommand;
import com.example.commonapi.dtos.CreateCategorieRequestDTO;
import com.example.commonapi.dtos.UpdateCategorieRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/proprietaire/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class ProprietaireCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createProprietaire(@RequestBody CreateCategorieRequestDTO request) {
        return commandGateway.send(new CreateCategorieCommand(
                UUID.randomUUID().toString(),
                request.getNom(),
                request.getPrenom(),
                request.getDdn(),
                request.getEmail(),
                request.getNumTel()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateProprietaire(@RequestBody UpdateCategorieRequestDTO request) {
        return commandGateway.send(new UpdateCategorieCommand(
                request.getId(),
                request.getNom(),
                request.getPrenom(),
                request.getDdn(),
                request.getEmail(),
                request.getNumTel()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @GetMapping("/eventStore/{id}")
    public Stream getEventStore(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }

}
