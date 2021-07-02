package com.oc.oc_lade.form;

import javax.validation.constraints.NotEmpty;

public class FormAjoutVoie {

    @NotEmpty(message="Veuillez renseigner un nom pour la voie.")
    private String nom;

    @NotEmpty(message="Veuillez sélectionner un secteur.")
    private String nomSecteur;

    private Boolean	equipe;

    @NotEmpty(message="Veuillez préciser la cotation.")
    private String cotation;

    public FormAjoutVoie() {
    }

    public FormAjoutVoie(String nom, String nomSecteur, Boolean equipe, String cotation) {
        this.nom = nom;
        this.nomSecteur = nomSecteur;
        this.equipe = equipe;
        this.cotation = cotation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public Boolean getEquipe() {
        return equipe;
    }

    public void setEquipe(Boolean equipe) {
        this.equipe = equipe;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    @Override
    public String toString() {
        return "FormAjoutVoie{" +
                "nom='" + nom + '\'' +
                ", nomSecteur='" + nomSecteur + '\'' +
                ", equipe=" + equipe +
                ", cotation='" + cotation + '\'' +
                '}';
    }
}
