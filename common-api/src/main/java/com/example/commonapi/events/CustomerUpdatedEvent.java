package com.example.commonapi.events;

public class CustomerUpdatedEvent extends BaseEvent<String> {
    private String nom ;
    private String adresse ;
    private String mail;
    private String tele;

    public CustomerUpdatedEvent(String id, String nom, String adresse,String mail,String tele) {
        super(id);
        this.nom=nom;
        this.adresse=adresse;
        this.mail=mail;
        this.tele=tele;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public String getTele() {
        return tele;
    }
}