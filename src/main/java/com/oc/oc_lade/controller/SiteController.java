package com.oc.oc_lade.controller;

import com.oc.oc_lade.form.FormAjoutSite;
import com.oc.oc_lade.service.CommentaireService;
import com.oc.oc_lade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/site")
public class SiteController {

    public static final String ATT_FORM_AJOUT_SITE							= "formAjoutSite";

    @Autowired
    private SiteService siteService;

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/ajout_site")
    public String ajoutSite(Model model) {
        model.addAttribute(ATT_FORM_AJOUT_SITE, new FormAjoutSite());
        return "ajout_site";
    }
}
