package com.oc.oc_lade.controller;

import com.oc.oc_lade.entity.Utilisateur;
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

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    public static final String ATT_SESSION_STATUT							= "sessionStatut";

    public static final String ATT_UTILISATEUR				 				= "utilisateur";

    public static final String ATT_FORM_INSCRIPTION 						= "formInscription";

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
}
