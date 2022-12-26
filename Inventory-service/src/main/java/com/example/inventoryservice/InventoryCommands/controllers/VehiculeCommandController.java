package com.example.inventoryservice.InventoryCommands.controllers;

import com.example.commonapi.commands.CreateProductCommand;
import com.example.commonapi.commands.UpdateProductCommand;
import com.example.commonapi.dtos.CreateProductRequestDTO;
import com.example.commonapi.dtos.UpdateProductRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/vehicule/commands")
@AllArgsConstructor
@CrossOrigin("*")
public class VehiculeCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> create(@RequestBody CreateProductRequestDTO request) {
        return commandGateway.send(new CreateProductCommand(
                UUID.randomUUID().toString(),
                request.getMatricule(),
                request.getMarque(),
                request.getModele(),
                request.getPuissanceFiscale(),
                request.getProprietaireId()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> update(@RequestBody UpdateProductRequestDTO request) {
        return commandGateway.send(new UpdateProductCommand(
                request.getId(),
                request.getMatricule(),
                request.getMarque(),
                request.getModele(),
                request.getPuissanceFiscale(),
                request.getProprietaireId()
        ));
    }

    @GetMapping("/eventStore/{id}")
    public Stream getEventStore(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }





}
