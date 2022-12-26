package com.example.inventoryservice.InventoryCommands.aggregates;

import com.example.commonapi.commands.CreateCategorieCommand;
import com.example.commonapi.commands.UpdateCategorieCommand;
import com.example.commonapi.events.CategorieCreatedEvent;
import com.example.commonapi.events.CategorieUpdatedEvent;
import com.example.commonapi.events.ProprietaireCreatedEvent;
import com.example.commonapi.events.ProprietaireUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategorieAggregate {
    @AggregateIdentifier
    private String id;
    private String nom;
    private String description;

    public CategorieAggregate() {
    }

    @CommandHandler
    public CategorieAggregate(CreateCategorieCommand command) {
        AggregateLifecycle.apply(
                new CategorieCreatedEvent(
                        command.getId()


                )
        );
    }

    @EventSourcingHandler
    public void on(CategorieCreatedEvent event) {
        this.id = event.getId(),
    }

    @CommandHandler
    public void handle(UpdateCategorieCommand command) {
        AggregateLifecycle.apply(
                new CategorieUpdatedEvent(
                        command.getId(),

        );
    }

    @EventSourcingHandler
    public void on(CategorieUpdatedEvent event) {
        this.id = event.getId();
        this.nom = event.getNom();

    }

}
