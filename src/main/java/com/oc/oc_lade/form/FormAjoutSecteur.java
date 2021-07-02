package com.oc.oc_lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutSecteur {

    @NotEmpty(message="Veuillez renseigner un nom de secteur.")
    @Size(min=2, max=30, message="Le nom du secteur n'a pas la longueur appropriée.")
    private String nom;

    @NotEmpty(message="Veuillez sélectionner un site.")
    private String nomSite;

    public FormAjoutSecteur() {
    }

    public FormAjoutSecteur(String nom, String nomSite) {
        this.nom = nom;
        this.nomSite = nomSite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    @Override
    public String toString() {
        return "FormAjoutSecteur{" +
                "nom='" + nom + '\'' +
                ", nomSite='" + nomSite + '\'' +
                '}';
    }
}
