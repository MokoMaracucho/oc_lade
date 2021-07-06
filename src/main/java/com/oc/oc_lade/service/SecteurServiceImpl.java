package com.oc.oc_lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.oc_lade.entity.Secteur;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutSecteur;
import com.oc.oc_lade.repository.SecteurRepository;
import com.oc.oc_lade.repository.SiteRepository;

@Service
public class SecteurServiceImpl implements SecteurService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SecteurRepository secteurRepository;

    @Override
    public void save(FormAjoutSecteur formAjoutSecteur, Utilisateur utilisateur) {
        Secteur secteur = new Secteur();
        secteur.setNom(formAjoutSecteur.getNom());
        secteur.setUtilisateur(utilisateur);
        Site site = siteRepository.getByNom(formAjoutSecteur.getNomSite());
        secteur.setSite(site);
        secteurRepository.save(secteur);
    }

    @Override
    public List<Secteur> findAll() {
        return secteurRepository.findAll();
    }

    @Override
    public List<Secteur> findByNomAndRegion(String nom, String region) throws ResourceNotFoundException {
        return secteurRepository.findByNomAndRegion(nom, region);
    }
}
