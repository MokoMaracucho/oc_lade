package com.oc.oc_lade.service;

import java.util.List;

import com.oc.oc_lade.entity.ReservationTopo;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.StatutReservationTopo;
import com.oc.oc_lade.entity.Topo;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutTopo;

public interface TopoService {

    public void save(FormAjoutTopo formAjoutTopo, Utilisateur utilisateur);

    public void enregistrerReservationTopo(Long idTopo, Utilisateur utilisateur);

    public List<Topo> findAll();

    public List<ReservationTopo> listeReservationsTopo();

    public List<ReservationTopo> listeReservationsTopo(Long idUtilisateur);

    public List<ReservationTopo> listeDemandesReservationTopo(Long idDemandeurReservationTopo);

    public void majReservationTopo(Long idReservationTopo, Utilisateur utilisateur, StatutReservationTopo reponseDemandeReservationTopo);
}
