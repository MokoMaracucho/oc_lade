package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutTopo;

public interface TopoService {

    public void save(FormAjoutTopo formAjoutTopo, Utilisateur utilisateur);
}
