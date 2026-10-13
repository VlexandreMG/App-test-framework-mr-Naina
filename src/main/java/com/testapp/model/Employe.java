package com.testapp.model;

public class Employe {
    private String nom;
    private String poste;

    public Employe(String nom, String poste) {
        this.nom = nom;
        this.poste = poste;
    }

    public Employe() {}

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getNom() { return nom; }
    public String getPoste() { return poste; }
}