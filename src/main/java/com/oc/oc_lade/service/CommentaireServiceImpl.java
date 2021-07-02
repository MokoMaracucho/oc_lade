package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Commentaire;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutCommentaire;
import com.oc.oc_lade.repository.CommentaireRepository;
import com.oc.oc_lade.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Override
    public void save(FormAjoutCommentaire formCommentaire, Utilisateur utilisateur, Long idSite) {
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaire(formCommentaire.getCommentaire());
        commentaire.setUtilisateur(utilisateur);
        Site site = siteRepository.getById(idSite);
        commentaire.setSite(site);
        commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> listeCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public List<Commentaire> findAllByIdSite(Long id) {
        return commentaireRepository.findAllByIdSite(id);
    }

    @Override
    public void deleteById(Long id) {
        commentaireRepository.deleteById(id);
    }
}
