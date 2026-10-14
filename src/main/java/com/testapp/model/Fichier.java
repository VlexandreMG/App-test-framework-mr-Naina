package com.testapp.model;


public class Fichier {
    private String nom;
    private byte[] contenu;
    private String extension;

    public Fichier() {}

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public byte[] getContenu() { return contenu; }
    public void setContenu(byte[] contenu) { this.contenu = contenu; }

    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }
}