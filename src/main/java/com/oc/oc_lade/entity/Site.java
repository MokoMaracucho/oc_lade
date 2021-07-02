package com.oc.oc_lade.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Site {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Veuillez sélectionner une région.")
    private String nom;

    @NotEmpty(message="Veuillez renseigner un nom de site.")
    private String region;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany
    private List<Commentaire> listeCommentaires;

    public Site() {
    }

    public Site(String nom, String region, Utilisateur utilisateur, List<Commentaire> listeCommentaires) {
        this.nom = nom;
        this.region = region;
        this.utilisateur = utilisateur;
        this.listeCommentaires = listeCommentaires;
    }

    public Site(Long id, String nom, String region, Utilisateur utilisateur, List<Commentaire> listeCommentaires) {
        this.id = id;
        this.nom = nom;
        this.region = region;
        this.utilisateur = utilisateur;
        this.listeCommentaires = listeCommentaires;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Commentaire> getListeCommentaires() {
        return listeCommentaires;
    }

    public void setListeCommentaires(List<Commentaire> listeCommentaires) {
        this.listeCommentaires = listeCommentaires;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", region='" + region + '\'' +
                ", utilisateur=" + utilisateur +
                ", listeCommentaires=" + listeCommentaires +
                '}';
    }
}
