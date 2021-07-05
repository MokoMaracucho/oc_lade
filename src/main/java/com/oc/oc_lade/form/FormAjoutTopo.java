package com.oc.oc_lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutTopo {

    @NotEmpty(message="Veuillez renseigner un nom pour le topo.")
    @Size(min=2, max=30, message="Le nom du topo n'a pas la longueur appropriée.")
    private String nom;

    @NotEmpty(message="Veuillez sélectionner une région.")
    private String region;

    @NotEmpty(message="Veuillez décrire le topo.")
    @Size(min=2, max=300, message="La description n'a pas la longueur appropriée.")
    private String description;

    public FormAjoutTopo() {
    }

    public FormAjoutTopo(String nom, String region, String description) {
        this.nom = nom;
        this.region = region;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FormAjoutTopo{" +
                "nom='" + nom + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
