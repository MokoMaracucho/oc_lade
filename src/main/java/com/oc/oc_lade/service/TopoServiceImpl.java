package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Topo;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutTopo;
import com.oc.oc_lade.repository.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TopoServiceImpl implements TopoService {

    @Autowired
    private TopoRepository topoRepository;

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
}
