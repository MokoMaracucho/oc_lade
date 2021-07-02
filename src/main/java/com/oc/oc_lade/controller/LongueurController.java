package com.oc.oc_lade.controller;

import com.oc.oc_lade.entity.Longueur;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.entity.Voie;
import com.oc.oc_lade.form.FormAjoutLongueur;
import com.oc.oc_lade.service.LongueurService;
import com.oc.oc_lade.service.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/longueur")
public class LongueurController {

    public static final String ATT_FORM_AJOUT_LONGUEUR						= "formAjoutLongueur";

    public static final String ATT_LISTE_VOIES								= "listeVoies";
    public static final String ATT_LISTE_LONGUEURS				 			= "listeLongueurs";

    public static final String ATT_UTILISATEUR								= "utilisateur";

    @Autowired
    private VoieService voieService;

    @Autowired
    private LongueurService longueurService;

    @GetMapping("/ajout_longueur")
    public String ajoutLongueur(Model model) {
        model.addAttribute(ATT_FORM_AJOUT_LONGUEUR, new FormAjoutLongueur());
        List<Voie> listeVoies = voieService.findAll();
        model.addAttribute(ATT_LISTE_VOIES, listeVoies);
        return "ajout_longueur";
    }

    @PostMapping("/traitement_formulaire_ajout_longueur")
    public String traitementAjoutLongueur(HttpServletRequest request, @Valid @ModelAttribute("formAjoutLongueur") FormAjoutLongueur formAjoutLongueur, BindingResult bindingResult, Model model) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            return "/ajout_longueur";
        } else {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
            longueurService.save(formAjoutLongueur, utilisateur);
            return "redirect:/longueur/liste_longueurs";
        }
    }

    @GetMapping("/liste_longueurs")
    public String listeLongueurs(Model model) {
        List<Longueur> listeLongueurs = longueurService.findAll();
        model.addAttribute(ATT_LISTE_LONGUEURS, listeLongueurs);
        return "liste_longueurs";
    }
}
