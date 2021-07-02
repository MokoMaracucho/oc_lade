package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormInscription;
import com.oc.oc_lade.form.FormMajUtilisateur;

import java.util.List;

public interface UtilisateurService {

    public void save(FormInscription formInscription);

    public Utilisateur getById(Long id) throws ResourceNotFoundException;

    public boolean existsByEmail(String email);

    public Utilisateur getByEmail(String email);

    public FormMajUtilisateur formulaireMajUtilisateur(Utilisateur utilisateur);

    public void updateUtilisateur(FormMajUtilisateur formMajUtilisateur);

    public List<Utilisateur> findAll();
}
