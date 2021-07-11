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
            List<Site> listeSites = siteService.findByNom(formRechercheAvancee.getNom());
            if(!listeSites.isEmpty()) {
                model.addAttribute(ATT_LISTE_SITES, listeSites);
            }
            List<Secteur> listeSecteurs = secteurService.findByNom(formRechercheAvancee.getNom());
            if(!listeSecteurs.isEmpty()) {
                model.addAttribute(ATT_LISTE_SECTEURS, listeSecteurs);
            }
            List<Voie> listeVoies = voieService.findByNom(formRechercheAvancee.getNom());
            if(!listeVoies.isEmpty()) {
                model.addAttribute(ATT_LISTE_VOIES, listeVoies);
            }
            List<Longueur> listeLongueurs = longueurService.findByNom(formRechercheAvancee.getNom());
            if(!listeLongueurs.isEmpty()) {
                model.addAttribute(ATT_LISTE_LONGUEURS, listeLongueurs);
            }
            List<Topo> listeTopos = topoService.findByNom(formRechercheAvancee.getNom());
            if(!listeTopos.isEmpty()) {
                model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
            }
        }
        if(!formRechercheAvancee.getRegion().isEmpty() && formRechercheAvancee.getNom().isEmpty()) {
            List<Site> listeSites = siteService.findByRegion(formRechercheAvancee.getRegion());
            if(!listeSites.isEmpty()) {
                model.addAttribute(ATT_LISTE_SITES, listeSites);
            }
            List<Topo> listeTopos = topoService.findByRegion(formRechercheAvancee.getRegion());
            if(!listeTopos.isEmpty()) {
                model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
            }
        }
        if(!formRechercheAvancee.getRegion().isEmpty() && !formRechercheAvancee.getNom().isEmpty()) {
            List<Site> listeSites = siteService.findByNomAndRegion(formRechercheAvancee.getNom(), formRechercheAvancee.getRegion());
            if(!listeSites.isEmpty()) {
                model.addAttribute(ATT_LISTE_SITES, listeSites);
            }
            List<Topo> listeTopos = topoService.findByNomAndRegion(formRechercheAvancee.getNom(), formRechercheAvancee.getRegion());
            if(!listeTopos.isEmpty()) {
                model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
            }
        }
        return "resultat_recherche";
    }
}
