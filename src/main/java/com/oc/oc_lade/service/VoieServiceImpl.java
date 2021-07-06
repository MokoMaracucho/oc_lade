package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Secteur;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.entity.Voie;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutVoie;
import com.oc.oc_lade.repository.SecteurRepository;
import com.oc.oc_lade.repository.VoieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoieServiceImpl implements VoieService {

    @Autowired
    private SecteurRepository secteurRepository;

    @Autowired
    private VoieRepository voieRepository;

    @Override
    public void save(FormAjoutVoie formAjoutVoie, Utilisateur utilisateur) {
        Voie voie = new Voie();
        voie.setNom(formAjoutVoie.getNom());
        voie.setEquipe(formAjoutVoie.getEquipe());
        voie.setCotation(formAjoutVoie.getCotation());
        voie.setUtilisateur(utilisateur);
        Secteur secteur = secteurRepository.getByNom(formAjoutVoie.getNomSecteur());
        voie.setSecteur(secteur);
        voieRepository.save(voie);
    }

    @Override
    public List<Voie> findAll() {
        return voieRepository.findAll();
    }

    @Override
    public List<Voie> findByNomAndRegion(String nom, String region) throws ResourceNotFoundException {
        return voieRepository.findByNomAndRegion(nom, region);
    }
}
