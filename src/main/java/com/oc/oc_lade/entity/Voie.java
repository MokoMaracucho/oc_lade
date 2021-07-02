package com.oc.oc_lade.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Voie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nom;

    private Boolean	equipe;

    @NotEmpty
    private String cotation;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Secteur secteur;

    public Voie() {
    }

    public Voie(String nom, Boolean equipe, String cotation, Utilisateur utilisateur, Secteur secteur) {
        this.nom = nom;
        this.equipe = equipe;
        this.cotation = cotation;
        this.utilisateur = utilisateur;
        this.secteur = secteur;
    }

    public Voie(Long id, String nom, Boolean equipe, String cotation, Utilisateur utilisateur, Secteur secteur) {
        this.id = id;
        this.nom = nom;
        this.equipe = equipe;
        this.cotation = cotation;
        this.utilisateur = utilisateur;
        this.secteur = secteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Voie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", equipe=" + equipe +
                ", cotation='" + cotation + '\'' +
                ", utilisateur=" + utilisateur +
                ", secteur=" + secteur +
                '}';
    }
}
