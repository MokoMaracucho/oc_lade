package com.oc.oc_lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutLongueur {

    @NotEmpty(message="Veuillez renseigner un nom pour la longueur.")
    @Size(min=2, max=30, message="Le nom de la longueur n'a pas la longueur appropriée.")
    private String nom;

    @NotEmpty(message="Veuillez sélectionner une voie.")
    private String nomVoie;

    @NotEmpty(message="Veuillez préciser la cotation.")
    private String cotation;

    public FormAjoutLongueur() {
    }

    public FormAjoutLongueur(String nom, String nomVoie, String cotation) {
        this.nom = nom;
        this.nomVoie = nomVoie;
        this.cotation = cotation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    @Override
    public String toString() {
        return "FormAjoutLongueur{" +
                "nom='" + nom + '\'' +
                ", nomVoie='" + nomVoie + '\'' +
                ", cotation='" + cotation + '\'' +
                '}';
    }
}
