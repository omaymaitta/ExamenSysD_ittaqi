package com.example.commonapi.events;

import lombok.Getter;

import java.util.Date;

@Getter
public class CategorieUpdatedEvent extends BaseEvent<String> {
    private String nom;
    private String description;

    public CategorieUpdatedEvent(String id, String nom, String description) {
        super(id);
        this.nom = nom;
        this.description = description;

    }
}
