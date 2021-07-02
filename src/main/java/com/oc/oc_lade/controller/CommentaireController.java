package com.oc.oc_lade.controller;

import com.oc.oc_lade.entity.Commentaire;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutCommentaire;
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
@RequestMapping("/commentaire")
public class CommentaireController {

    public static final String ATT_FORM_AJOUT_COMMENTAIRE					= "formAjoutCommentaire";

    public static final String ATT_SITE										= "site";
    public static final String ATT_UTILISATEUR								= "utilisateur";

    public static final String ATT_LISTE_COMMENTAIRES_BY_ID_SITE			= "listeCommentairesByIdSite";

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private SiteService siteService;

    @PostMapping("/traitement_formulaire_ajout_commentaire")
    public String traitementFormulaireAjoutCommentaire(HttpServletRequest request, @Valid @ModelAttribute("formAjoutCommentaire") FormAjoutCommentaire formAjoutCommentaire, @RequestParam(name="idSite") Long idSite, BindingResult bindingResult, Model model) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            return "/liste_commentaires_par_id_site";
        } else {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
            List<Commentaire> listeCommentairesByIdSite = commentaireService.findAllByIdSite(idSite);
            model.addAttribute(ATT_LISTE_COMMENTAIRES_BY_ID_SITE, listeCommentairesByIdSite);
            commentaireService.save(formAjoutCommentaire, utilisateur, idSite);
            FormAjoutCommentaire newFormAjoutCommentaire = new FormAjoutCommentaire();
            newFormAjoutCommentaire.setIdSite(idSite);
            model.addAttribute(ATT_FORM_AJOUT_COMMENTAIRE, newFormAjoutCommentaire);
            return "redirect:/commentaire/liste_commentaires_par_id_site?id=" + idSite;
        }
    }

    @GetMapping("/liste_commentaires_par_id_site")
    public String listeCommentairesByIdSite(HttpServletRequest request, @RequestParam(name="id") Long idSite, Model model) throws ResourceNotFoundException {
        Site site = siteService.findById(idSite);
        model.addAttribute(ATT_SITE, site);
        List<Commentaire> listeCommentairesByIdSite = commentaireService.findAllByIdSite(idSite);
        model.addAttribute(ATT_LISTE_COMMENTAIRES_BY_ID_SITE, listeCommentairesByIdSite);
        FormAjoutCommentaire formAjoutCommentaire = new FormAjoutCommentaire();
        formAjoutCommentaire.setIdSite(idSite);
        model.addAttribute(ATT_FORM_AJOUT_COMMENTAIRE, formAjoutCommentaire);
        return "liste_commentaires";
    }

    @PostMapping("/suppression_commentaire_par_id")
    public String deleteById(@RequestParam(name="id") Long id, @RequestParam(name="idSite") Long idSite, Model model) {
        commentaireService.deleteById(id);
        return "redirect:/commentaire/liste_commentaires_par_id_site?id=" + idSite;
    }
}
