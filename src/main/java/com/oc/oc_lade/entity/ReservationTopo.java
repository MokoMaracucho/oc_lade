package com.oc.oc_lade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class ReservationTopo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatutReservationTopo statut;

    @ManyToOne
    private Topo topo;

    @ManyToOne
    private Utilisateur utilisateur;

    public ReservationTopo() {
    }

    public ReservationTopo(StatutReservationTopo statut, Topo topo, Utilisateur utilisateur) {
        this.statut = statut;
        this.topo = topo;
        this.utilisateur = utilisateur;
    }

    public ReservationTopo(Long id, StatutReservationTopo statut, Topo topo, Utilisateur utilisateur) {
        this.id = id;
        this.statut = statut;
        this.topo = topo;
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutReservationTopo getStatut() {
        return statut;
    }

    public void setStatut(StatutReservationTopo statut) {
        this.statut = statut;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "ReservationTopo{" +
                "id=" + id +
                ", statut=" + statut +
                ", topo=" + topo +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
