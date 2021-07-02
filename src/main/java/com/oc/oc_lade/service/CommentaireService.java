package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Commentaire;

import java.util.List;

public interface CommentaireService {

    public List<Commentaire> listeCommentaires();

    public List<Commentaire> findAllByIdSite(Long id);

    public void deleteById(Long idCommentaire);
}
