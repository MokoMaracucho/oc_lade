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

    private Boolean officiel;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany
    @JoinColumn(name="secteur_id")
    private List<Secteur> listeSecteurs;

    @OneToMany
    @JoinColumn(name="commentaire_id")
    private List<Commentaire> listeCommentaires;

    public Site() {
    }

    public Site(String nom, String region, Boolean officiel, Utilisateur utilisateur, List<Secteur> listeSecteurs, List<Commentaire> listeCommentaires) {
        this.nom = nom;
        this.region = region;
        this.officiel = officiel;
        this.utilisateur = utilisateur;
        this.listeSecteurs = listeSecteurs;
        this.listeCommentaires = listeCommentaires;
    }

    public Site(Long id, String nom, String region, Boolean officiel, Utilisateur utilisateur, List<Secteur> listeSecteurs, List<Commentaire> listeCommentaires) {
        this.id = id;
        this.nom = nom;
        this.region = region;
        this.officiel = officiel;
        this.utilisateur = utilisateur;
        this.listeSecteurs = listeSecteurs;
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

    public Boolean getOfficiel() {
        return officiel;
    }

    public void setOfficiel(Boolean officiel) {
        this.officiel = officiel;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Secteur> getListeSecteurs() {
        return listeSecteurs;
    }

    public void setListeSecteurs(List<Secteur> listeSecteurs) {
        this.listeSecteurs = listeSecteurs;
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
                ", officiel=" + officiel +
                ", utilisateur=" + utilisateur +
                ", listeSecteurs=" + listeSecteurs +
                ", listeCommentaires=" + listeCommentaires +
                '}';
    }
}
