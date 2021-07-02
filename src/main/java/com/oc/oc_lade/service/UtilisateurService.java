package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormInscription;

public interface UtilisateurService {

    public void save(FormInscription formInscription);

    public boolean existsByEmail(String email);

    public Utilisateur getByEmail(String email);
}
