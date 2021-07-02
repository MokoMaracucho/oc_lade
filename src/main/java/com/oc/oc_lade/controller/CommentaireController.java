package com.oc.oc_lade.controller;

import com.oc.oc_lade.entity.Commentaire;
import com.oc.oc_lade.entity.Site;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormAjoutCommentaire;
import com.oc.oc_lade.service.CommentaireService;
import com.oc.oc_lade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {

    public static final String ATT_FORM_AJOUT_COMMENTAIRE					= "formAjoutCommentaire";

    public static final String ATT_SITE										= "site";

    public static final String ATT_LISTE_COMMENTAIRES_BY_ID_SITE			= "listeCommentairesByIdSite";

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private SiteService siteService;

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
