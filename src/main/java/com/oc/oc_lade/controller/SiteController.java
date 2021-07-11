package com.oc.oc_lade.controller;

import com.oc.oc_lade.entity.Commentaire;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutSite;
import com.oc.oc_lade.service.CommentaireService;
import com.oc.oc_lade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/site")
public class SiteController {

    public static final String ATT_FORM_AJOUT_SITE							= "formAjoutSite";

    public static final String ATT_UTILISATEUR								= "utilisateur";

    public static final String ATT_LISTE_SITES				 				= "listeSites";
    public static final String ATT_LISTE_COMMENTAIRES						= "listeCommentaires";

    @Autowired
    private SiteService siteService;

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/ajout_site")
    public String ajoutSite(Model model) {
        model.addAttribute(ATT_FORM_AJOUT_SITE, new FormAjoutSite());
        return "ajout_site";
    }

    @PostMapping("/traitement_formulaire_ajout_site")
    public String traitementAjoutSite(HttpServletRequest request, @Valid @ModelAttribute("formAjoutSite") FormAjoutSite formAjoutSite, BindingResult bindingResult, Model model) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            return "/ajout_site";
        } else {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
            siteService.save(formAjoutSite, utilisateur);
            return "redirect:/site/liste_sites";
        }
    }

    @GetMapping("/liste_sites")
    public String listeSites(Model model) {
        List<Commentaire> listeCommentaires = commentaireService.listeCommentaires();
        model.addAttribute(ATT_LISTE_COMMENTAIRES, listeCommentaires);
        List<Site> listeSites = siteService.listeSites();
        model.addAttribute(ATT_LISTE_SITES, listeSites);
        return "liste_sites";
    }

    @GetMapping("/site_officiel")
    public String siteOfficiel(HttpServletRequest request, @RequestParam(name="id") Long idSite, Model model) throws ResourceNotFoundException {
        Site site = siteService.findById(idSite);
        site.setOfficiel(true);
        siteService.save(site);
        List<Commentaire> listeCommentaires = commentaireService.listeCommentaires();
        model.addAttribute(ATT_LISTE_COMMENTAIRES, listeCommentaires);
        List<Site> listeSites = siteService.listeSites();
        model.addAttribute(ATT_LISTE_SITES, listeSites);
        return "liste_sites";
    }
}
