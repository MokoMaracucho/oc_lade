package com.oc.oc_lade.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Longueur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nom;

    @NotEmpty
    private String cotation;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Voie voie;

    public Longueur() {
    }

    public Longueur(String nom, String cotation, Utilisateur utilisateur, Voie voie) {
        this.nom = nom;
        this.cotation = cotation;
        this.utilisateur = utilisateur;
        this.voie = voie;
    }

    public Longueur(Long id, String nom, String cotation, Utilisateur utilisateur, Voie voie) {
        this.id = id;
        this.nom = nom;
        this.cotation = cotation;
        this.utilisateur = utilisateur;
        this.voie = voie;
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

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    @Override
    public String toString() {
        return "Longueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cotation='" + cotation + '\'' +
                ", utilisateur=" + utilisateur +
                ", voie=" + voie +
                '}';
    }
}
