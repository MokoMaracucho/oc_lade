package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Longueur;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutLongueur;

import java.util.List;

public interface LongueurService {

    public void save(FormAjoutLongueur formAjoutLongueur, Utilisateur utilisateur);

    public List<Longueur> findAll();

    public List<Longueur> findByNomAndRegion(String nom, String region) throws ResourceNotFoundException;

    public List<Longueur> findByNom(String nom) throws ResourceNotFoundException;
}
