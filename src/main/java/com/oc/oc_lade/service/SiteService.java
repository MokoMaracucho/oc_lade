package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutSite;

public interface SiteService {

    public void save(FormAjoutSite formAjoutSite, Utilisateur utilisateur);
}
