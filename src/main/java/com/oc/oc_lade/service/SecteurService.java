package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Secteur;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutSecteur;

import java.util.List;

public interface SecteurService {

    public void save(FormAjoutSecteur formAjoutSecteur, Utilisateur utilisateur);

    public List<Secteur> findAll();
}
