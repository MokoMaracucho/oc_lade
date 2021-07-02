package com.oc.oc_lade.controller;

import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormConnection;
import com.oc.oc_lade.form.FormInscription;
import com.oc.oc_lade.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    public static final String ATT_SESSION_STATUT							= "sessionStatut";

    public static final String ATT_UTILISATEUR				 				= "utilisateur";
    public static final String ATT_LISTE_UTILISATEURS				 		= "listeUtilisateurs";

    public static final String ATT_FORM_INSCRIPTION 						= "formInscription";
    public static final String ATT_FORM_CONNECTION 							= "formConnection";

    @Autowired
    private UtilisateurService utilisateurService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/inscription_utilisateur")
    public String inscriptionUtilisateur(Model model) {
        model.addAttribute(ATT_FORM_INSCRIPTION, new FormInscription());
        return "inscription_utilisateur";
    }

    @PostMapping("/traitement_formulaire_inscription")
    public String traitementInscriptionUtilisateur(HttpServletRequest request, @Valid @ModelAttribute("formInscription") FormInscription formInscription, BindingResult bindingResult, Model model) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            session.setAttribute(ATT_SESSION_STATUT, false);
            return "/inscription_utilisateur";
        } else {
            utilisateurService.save(formInscription);
            Utilisateur utilisateur = utilisateurService.getByEmail(formInscription.getEmail());
            session.setAttribute(ATT_SESSION_STATUT, true);
            session.setAttribute(ATT_UTILISATEUR, utilisateur);
            model.addAttribute(ATT_UTILISATEUR, utilisateur);
            return "redirect:/utilisateur/liste_utilisateurs";
        }
    }

    @GetMapping("/connection_utilisateur")
    public String connectionUtilisateur(Model model) {
        model.addAttribute(ATT_FORM_CONNECTION, new FormConnection());
        return "connection_utilisateur";
    }

    @PostMapping("/traitement_formulaire_connection")
    public String traitementConnectionUtilisateur(HttpServletRequest request, @Valid @ModelAttribute("formConnection") FormConnection formConnection, BindingResult bindingResult, Model model) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            session.setAttribute(ATT_SESSION_STATUT, false);
            return "connection_utilisateur";
        } else {
            Utilisateur utilisateur = utilisateurService.getByEmail(formConnection.getEmailFormConnection());
            session.setAttribute(ATT_SESSION_STATUT, true);
            session.setAttribute(ATT_UTILISATEUR, utilisateur);
            model.addAttribute(ATT_UTILISATEUR, utilisateur);
            return "redirect:/utilisateur/liste_utilisateurs";
        }
    }

    @GetMapping("/deconnection_utilisateur")
    public String deconnectionUtilisateur(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.invalidate();
        model.addAttribute(ATT_SESSION_STATUT, false);
        return "redirect:/utilisateur/connection_utilisateur";
    }

    @GetMapping("/liste_utilisateurs")
    public String listeUtilisateurs(HttpServletRequest request, Model model) throws ResourceNotFoundException {
        List<Utilisateur> listeUtilisateurs = utilisateurService.findAll();
        HttpSession session = request.getSession();
        model.addAttribute(ATT_LISTE_UTILISATEURS, listeUtilisateurs);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
        Long id = utilisateur.getId();
        utilisateur = utilisateurService.getById(id);
        session.setAttribute(ATT_UTILISATEUR, utilisateur);
        model.addAttribute(ATT_UTILISATEUR, utilisateur);
        return "liste_utilisateurs";
    }
}
