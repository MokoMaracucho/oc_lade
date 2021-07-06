package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Commentaire;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutSite;
import com.oc.oc_lade.repository.CommentaireRepository;
import com.oc.oc_lade.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public void save(FormAjoutSite formAjoutSite, Utilisateur utilisateur) {
        Site site = new Site();
        site.setNom(formAjoutSite.getNom());
        site.setRegion(formAjoutSite.getRegion());
        site.setUtilisateur(utilisateur);
        siteRepository.save(site);
        if(formAjoutSite.getCommentaire() != null) {
            Commentaire commentaire = new Commentaire();
            commentaire.setCommentaire(formAjoutSite.getCommentaire());
            commentaire.setUtilisateur(utilisateur);
            Site siteCree = siteRepository.getById(site.getId());
            commentaire.setSite(siteCree);
            commentaireRepository.save(commentaire);
        }
    }

    @Override
    public List<Site> listeSites() {
        return siteRepository.findAll();
    }

    @Override
    public Site findById(Long id) throws ResourceNotFoundException {
        return siteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public List<Site> findAllByNom(String nom, String region) throws ResourceNotFoundException {
        return siteRepository.findAllByNom(nom, region);
    }
}
