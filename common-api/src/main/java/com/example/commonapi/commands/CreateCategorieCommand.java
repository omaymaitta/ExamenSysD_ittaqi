package com.example.commonapi.commands;

import java.util.Date;

public class CreateCategorieCommand extends BaseCommand<String>{
    private String nom;
    private String prenom;
    private Date ddn;
    private String email;
    private String numTel;

    public CreateCategorieCommand(String id, String nom, String prenom, Date ddn, String email, String numTel) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
        this.email = email;
        this.numTel = numTel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDdn() {
        return ddn;
    }

    public String getEmail() {
        return email;
    }

    public String getNumTel() {
        return numTel;
    }

}