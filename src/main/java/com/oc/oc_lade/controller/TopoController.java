package com.oc.oc_lade.controller;

import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutTopo;
import com.oc.oc_lade.service.TopoService;
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
@RequestMapping("/topo")
public class TopoController {

    public static final String ATT_FORM_AJOUT_TOPO						= "formAjoutTopo";

    public static final String ATT_UTILISATEUR							= "utilisateur";

    @Autowired
    private TopoService topoService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/ajout_topo")
    public String ajoutTopo(Model model) {
        model.addAttribute(ATT_FORM_AJOUT_TOPO, new FormAjoutTopo());
        return "ajout_topo";
    }

    @PostMapping("/traitement_formulaire_ajout_topo")
    public String traitementAjoutTopo(HttpServletRequest request, @Valid @ModelAttribute("formAjoutTopo") FormAjoutTopo formAjoutTopo, BindingResult bindingResult, Model model) {
        HttpSession session = request.getSession();
        if(bindingResult.hasErrors()) {
            return "/ajout_topo";
        } else {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
            topoService.save(formAjoutTopo, utilisateur);
            return "redirect:/topo/liste_topos";
        }
    }
}
