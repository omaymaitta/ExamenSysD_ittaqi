package com.example.commonapi.commands;

public class UpdateCustomerCommand extends BaseCommand<String>{
    private String nom ;
    private String adresse ;
    private String mail;
    private String tele;

    public UpdateCustomerCommand(String id, String nom, String adresse , String mail,String tele) {
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
