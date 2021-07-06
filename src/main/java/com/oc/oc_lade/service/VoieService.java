package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.entity.Voie;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutVoie;

import java.util.List;

public interface VoieService {

    public void save(FormAjoutVoie formAjoutVoie, Utilisateur utilisateur);

    public List<Voie> findAll();

    public List<Voie> findByNomAndRegion(String nom, String region) throws ResourceNotFoundException;
}
