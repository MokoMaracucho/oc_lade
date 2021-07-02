package com.oc.oc_lade.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty()
    private String commentaire;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Site site;

    public Commentaire() {
    }

    public Commentaire(String commentaire, Utilisateur utilisateur, Site site) {
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
        this.site = site;
    }

    public Commentaire(Long id, String commentaire, Utilisateur utilisateur, Site site) {
        this.id = id;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
        this.site = site;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
        return "Commentaire{" +
                "id=" + id +
                ", commentaire='" + commentaire + '\'' +
                ", utilisateur=" + utilisateur +
                ", site=" + site +
                '}';
    }
}
