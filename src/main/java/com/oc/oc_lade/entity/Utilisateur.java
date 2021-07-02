package com.oc.oc_lade.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String prenom;

    private String nom;

    private String email;

    private String motPasse;

    @Enumerated(EnumType.STRING)
    private Privilege privilege;

    private Timestamp dateInscription;

    public Utilisateur() {
    }

    public Utilisateur(String prenom, String nom, String email, String motPasse, Privilege privilege, Timestamp dateInscription) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.motPasse = motPasse;
        this.privilege = privilege;
        this.dateInscription = dateInscription;
    }

    public Utilisateur(Long id, String prenom, String nom, String email, String motPasse, Privilege privilege, Timestamp dateInscription) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.motPasse = motPasse;
        this.privilege = privilege;
        this.dateInscription = dateInscription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Timestamp dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", motPasse='" + motPasse + '\'' +
                ", privilege=" + privilege +
                ", dateInscription=" + dateInscription +
                '}';
    }
}
