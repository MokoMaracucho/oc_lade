package com.oc.oc_lade.entity;

import java.util.List;

import javax.persistence.*;
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

    @OneToMany
    @JoinColumn(name="longueur_id")
    private List<Longueur> listeLongueurs;

    public Voie() {
    }

    public Voie(String nom, Boolean equipe, String cotation, Utilisateur utilisateur, Secteur secteur, List<Longueur> listeLongueurs) {
        this.nom = nom;
        this.equipe = equipe;
        this.cotation = cotation;
        this.utilisateur = utilisateur;
        this.secteur = secteur;
        this.listeLongueurs = listeLongueurs;
    }

    public Voie(Long id, String nom, Boolean equipe, String cotation, Utilisateur utilisateur, Secteur secteur, List<Longueur> listeLongueurs) {
        this.id = id;
        this.nom = nom;
        this.equipe = equipe;
        this.cotation = cotation;
        this.utilisateur = utilisateur;
        this.secteur = secteur;
        this.listeLongueurs = listeLongueurs;
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

    public List<Longueur> getListeLongueurs() {
        return listeLongueurs;
    }

    public void setListeLongueurs(List<Longueur> listeLongueurs) {
        this.listeLongueurs = listeLongueurs;
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
                ", listeLongueurs=" + listeLongueurs +
                '}';
    }
}
