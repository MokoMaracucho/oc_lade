package com.oc.oc_lade.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Topo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nom;

    @NotEmpty
    private String region;

    @NotEmpty
    private String description;

    private Timestamp dateParution;

    private Boolean disponibilite;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany
    private List<ReservationTopo> listeReservationsTopos;

    public Topo() {
    }

    public Topo(String nom, String region, String description, Timestamp dateParution, Boolean disponibilite, Utilisateur utilisateur, List<ReservationTopo> listeReservationsTopos) {
        this.nom = nom;
        this.region = region;
        this.description = description;
        this.dateParution = dateParution;
        this.disponibilite = disponibilite;
        this.utilisateur = utilisateur;
        this.listeReservationsTopos = listeReservationsTopos;
    }

    public Topo(Long id, String nom, String region, String description, Timestamp dateParution, Boolean disponibilite, Utilisateur utilisateur, List<ReservationTopo> listeReservationsTopos) {
        this.id = id;
        this.nom = nom;
        this.region = region;
        this.description = description;
        this.dateParution = dateParution;
        this.disponibilite = disponibilite;
        this.utilisateur = utilisateur;
        this.listeReservationsTopos = listeReservationsTopos;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateParution() {
        return dateParution;
    }

    public void setDateParution(Timestamp dateParution) {
        this.dateParution = dateParution;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<ReservationTopo> getListeReservationsTopos() {
        return listeReservationsTopos;
    }

    public void setListeReservationsTopos(List<ReservationTopo> listeReservationsTopos) {
        this.listeReservationsTopos = listeReservationsTopos;
    }

    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", region='" + region + '\'' +
                ", description='" + description + '\'' +
                ", dateParution=" + dateParution +
                ", disponibilite=" + disponibilite +
                ", utilisateur=" + utilisateur +
                ", listeReservationsTopos=" + listeReservationsTopos +
                '}';
    }
}
