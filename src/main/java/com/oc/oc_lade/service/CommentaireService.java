package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Commentaire;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutCommentaire;

import java.util.List;

public interface CommentaireService {

    public void save(FormAjoutCommentaire formCommentaire, Utilisateur utilisateur, Long idSite);

    public List<Commentaire> listeCommentaires();

    public List<Commentaire> findAllByIdSite(Long id);

    public void deleteById(Long idCommentaire);
}
