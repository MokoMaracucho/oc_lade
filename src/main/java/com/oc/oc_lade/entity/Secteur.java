package com.oc.oc_lade.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Secteur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nom;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Site site;

    @OneToMany
    @JoinColumn(name="voie_id")
    private List<Voie> listeVoies;

    public Secteur() {
    }

    public Secteur(String nom, Utilisateur utilisateur, Site site) {
        this.nom = nom;
        this.utilisateur = utilisateur;
        this.site = site;
    }

    public Secteur(Long id, String nom, Utilisateur utilisateur, Site site) {
        this.id = id;
        this.nom = nom;
        this.utilisateur = utilisateur;
        this.site = site;
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Secteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", utilisateur=" + utilisateur +
                ", site=" + site +
                '}';
    }
}
