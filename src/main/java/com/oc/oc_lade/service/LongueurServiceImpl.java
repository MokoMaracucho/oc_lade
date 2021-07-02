package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Longueur;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.entity.Voie;
import com.oc.oc_lade.form.FormAjoutLongueur;
import com.oc.oc_lade.repository.LongueurRepository;
import com.oc.oc_lade.repository.VoieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LongueurServiceImpl implements LongueurService {

    @Autowired
    private VoieRepository voieRepository;

    @Autowired
    private LongueurRepository longueurRepository;

    @Override
    public void save(FormAjoutLongueur formAjoutLongueur, Utilisateur utilisateur) {
        Longueur longueur = new Longueur();
        longueur.setNom(formAjoutLongueur.getNom());
        longueur.setCotation(formAjoutLongueur.getCotation());
        longueur.setUtilisateur(utilisateur);
        Voie voie = voieRepository.getByNom(formAjoutLongueur.getNomVoie());
        longueur.setVoie(voie);
        longueurRepository.save(longueur);
    }

    @Override
    public List<Longueur> findAll() {
        return longueurRepository.findAll();
    }
}
