package com.oc.oc_lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutSite {

    @NotEmpty(message="Veuillez renseigner un nom pour le site.")
    @Size(min=2, max=30, message="Le nom du site n'a pas la longueur appropriée.")
    private String nom;

    @NotEmpty(message="Veuillez sélectionner une région.")
    private String region;

    @Size(min=2, max=300, message="Le commentaire n'a pas la longueur appropriée.")
    private String commentaire;

    public FormAjoutSite() {
    }

    public FormAjoutSite(String nom, String region, String commentaire) {
        this.nom = nom;
        this.region = region;
        this.commentaire = commentaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "FormAjoutSite{" +
                "nom='" + nom + '\'' +
                ", region='" + region + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
