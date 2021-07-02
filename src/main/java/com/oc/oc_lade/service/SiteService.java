package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutSite;

import java.util.List;

public interface SiteService {

    public void save(FormAjoutSite formAjoutSite, Utilisateur utilisateur);

    public Site findById(Long id) throws ResourceNotFoundException;

    public List<Site> listeSites();
}
