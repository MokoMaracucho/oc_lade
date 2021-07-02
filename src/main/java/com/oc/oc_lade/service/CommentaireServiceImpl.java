package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Commentaire;
import com.oc.oc_lade.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    @Transactional
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
