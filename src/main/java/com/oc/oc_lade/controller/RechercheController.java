package com.oc.oc_lade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oc.oc_lade.entity.*;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormRechercheAvancee;
import com.oc.oc_lade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recherche")
public class RechercheController {

    public static final String ATT_FORM_RECHERCHE_AVANCEE				= "formRechercheAvancee";

    public static final String ATT_LISTE_SITES				 			= "listeSites";
    public static final String ATT_LISTE_SECTEURS						= "listeSecteurs";
    public static final String ATT_LISTE_VOIES							= "listeVoies";
    public static final String ATT_LISTE_LONGUEURS						= "listeLongueurs";
    public static final String ATT_LISTE_TOPOS							= "listeTopos";

    @Autowired
    private SiteService siteService;

    @Autowired
    private SecteurService secteurService;

    @Autowired
    private VoieService voieService;

    @Autowired
    private LongueurService longueurService;

    @Autowired
    private TopoService topoService;

    @GetMapping("/recherche_avancee")
    public String rechercheAvancee(Model model) {
        model.addAttribute(ATT_FORM_RECHERCHE_AVANCEE, new FormRechercheAvancee());
        return "recherche_avancee";
    }

    @PostMapping("/traitement_formulaire_recherche_avancee")
    public String traitementFormulaireRechercheAvancee(HttpServletRequest request, FormRechercheAvancee formRechercheAvancee, Model model) throws ResourceNotFoundException {
        if(!formRechercheAvancee.getNom().isEmpty() && formRechercheAvancee.getRegion().isEmpty()) {
            List<Site> listeSites = siteService.getByNom(formRechercheAvancee.getNom());
            if(!listeSites.isEmpty()) {
                model.addAttribute(ATT_LISTE_SITES, listeSites);
            }
            List<Secteur> listeSecteurs = secteurService.getByNom(formRechercheAvancee.getNom());
            if(!listeSecteurs.isEmpty()) {
                model.addAttribute(ATT_LISTE_SECTEURS, listeSecteurs);
            }
            List<Voie> listeVoies = voieService.getByNom(formRechercheAvancee.getNom());
            if(!listeVoies.isEmpty()) {
                model.addAttribute(ATT_LISTE_VOIES, listeVoies);
            }
            List<Longueur> listeLongueurs = longueurService.getByNom(formRechercheAvancee.getNom());
            if(!listeLongueurs.isEmpty()) {
                model.addAttribute(ATT_LISTE_LONGUEURS, listeLongueurs);
            }
            List<Topo> listeTopos = topoService.getByNom(formRechercheAvancee.getNom());
            if(!listeTopos.isEmpty()) {
                model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
            }
        }
        if(!formRechercheAvancee.getRegion().isEmpty() && formRechercheAvancee.getNom().isEmpty()) {
            List<Site> listeSites = siteService.rechercheRegion(formRechercheAvancee.getRegion());
            if(!listeSites.isEmpty()) {
                model.addAttribute(ATT_LISTE_SITES, listeSites);
            }
            List<Topo> listeTopos = topoService.rechercheRegion(formRechercheAvancee.getRegion());
            if(!listeTopos.isEmpty()) {
                model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
            }
        }
        if(!formRechercheAvancee.getRegion().isEmpty() && !formRechercheAvancee.getNom().isEmpty()) {
            List<Site> listeSites = siteService.rechercheNom(formRechercheAvancee.getNom(), formRechercheAvancee.getRegion());
            if(!listeSites.isEmpty()) {
                model.addAttribute(ATT_LISTE_SITES, listeSites);
            }
            List<Topo> listeTopos = topoService.rechercheNom(formRechercheAvancee.getNom(), formRechercheAvancee.getRegion());
            if(!listeTopos.isEmpty()) {
                model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
            }
        }
        return "resultat_recherche";
    }
}
