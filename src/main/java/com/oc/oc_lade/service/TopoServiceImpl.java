package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.*;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutTopo;
import com.oc.oc_lade.repository.ReservationTopoRepository;
import com.oc.oc_lade.repository.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TopoServiceImpl implements TopoService {

    @Autowired
    private TopoRepository topoRepository;

    @Autowired
    private ReservationTopoRepository reservationTopoRepository;

    @Override
    public void save(FormAjoutTopo formAjoutTopo, Utilisateur utilisateur) {
        Topo topo = new Topo();
        topo.setNom(formAjoutTopo.getNom());
        topo.setRegion(formAjoutTopo.getRegion());
        topo.setDescription(formAjoutTopo.getDescription());
        topo.setDateParution(new Timestamp(System.currentTimeMillis()));
        topo.setDisponibilite(true);
        topo.setUtilisateur(utilisateur);
        topoRepository.save(topo);
    }

    @Override
    public void enregistrerReservationTopo(Long idTopo, Utilisateur utilisateur) {
        Topo topo = topoRepository.getById(idTopo);
        topo.setDisponibilite(false);
        topoRepository.save(topo);
        ReservationTopo reservationTopo = new ReservationTopo();
        reservationTopo.setStatut(StatutReservationTopo.EN_ATTENTE);
        reservationTopo.setTopo(topo);
        reservationTopo.setUtilisateur(utilisateur);
        reservationTopoRepository.save(reservationTopo);
    }

    @Override
    public List<ReservationTopo> listeReservationsTopo(Long id) {
        return reservationTopoRepository.findAllByIdProprietaireTopo(id);
    }

    @Override
    @Transactional
    public List<ReservationTopo> listeDemandesReservationTopo(Long idDemandeurReservationTopo) {
        return reservationTopoRepository.findAllByIdDemandeurReservationTopo(idDemandeurReservationTopo);
    }

    @Override
    public List<Topo> findAll() {
        return topoRepository.findAll();
    }

    @Override
    public List<ReservationTopo> listeReservationsTopo() {
        return null;
    }

    @Override
    public void majReservationTopo(Long idReservationTopo, Utilisateur utilisateur, StatutReservationTopo reponseReservationTopo) {
        ReservationTopo reservationTopo = reservationTopoRepository.getById(idReservationTopo);
        Topo topo = reservationTopo.getTopo();
        Topo topoToUpdate = topoRepository.getById(topo.getId());
        switch(reponseReservationTopo) {
            case ACCEPTEE:
                reservationTopo.setStatut(StatutReservationTopo.ACCEPTEE);
                reservationTopoRepository.save(reservationTopo);
                break;
            case REFUSEE:
                reservationTopo.setStatut(StatutReservationTopo.REFUSEE);
                reservationTopoRepository.save(reservationTopo);
                topoToUpdate = topoRepository.getById(topo.getId());
                topoToUpdate.setDisponibilite(true);
                topoRepository.save(topoToUpdate);
                break;
            case TERMINEE:
                reservationTopo.setStatut(StatutReservationTopo.TERMINEE);
                reservationTopoRepository.save(reservationTopo);
                topoToUpdate.setDisponibilite(true);
                topoRepository.save(topoToUpdate);
                break;
            default:
                break;
        }
    }
}
