package com.example.customerservice.customerCommands.aggregates;

import com.example.commonapi.commands.CreateCustomerCommand;
import com.example.commonapi.commands.UpdateCustomerCommand;
import com.example.commonapi.events.CustomerCreatedEvent;

import com.example.commonapi.events.CustomerUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ClientAggregate {
    @AggregateIdentifier
    private String id;
    private String nom ;
    private String adresse ;
    private String mail;
    private String tele;

    public ClientAggregate() {
    }

    @CommandHandler
    public ClientAggregate(CreateCustomerCommand command) {

        AggregateLifecycle.apply(new CustomerCreatedEvent(
                command.getId(),
                command.getNom(),
                command.getAdresse(),
                command.getMail(),
                command.getTele()
        ));
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        this.id = event.getId();
        this.nom= event.getNom();
        this.adresse= event.getAdresse();
        this.tele= event.getTele();
        this.mail= event.getMail();
    }

    @CommandHandler
    public void handle(UpdateCustomerCommand command) {
        AggregateLifecycle.apply(new CustomerUpdatedEvent(
                command.getId(),
                command.getNom(),
                command.getAdresse(),
                command.getMail(),
                command.getTele()
        ));
    }

    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event) {
        this.nom= event.getNom();
        this.adresse= event.getAdresse();
        this.tele= event.getTele();
        this.mail= event.getMail();
    }
}
