package com.oc.oc_lade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.oc.oc_lade.entity.ReservationTopo;
import com.oc.oc_lade.entity.StatutReservationTopo;
import com.oc.oc_lade.entity.Topo;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutTopo;
import com.oc.oc_lade.service.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oc.oc_lade.entity.ReservationTopo;
import com.oc.oc_lade.entity.StatutReservationTopo;
import com.oc.oc_lade.entity.Topo;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.form.FormAjoutTopo;
import com.oc.oc_lade.service.TopoService;

@Controller
@RequestMapping("/topo")
public class TopoController {

    public static final String ATT_FORM_AJOUT_TOPO						= "formAjoutTopo";

    public static final String ATT_LISTE_TOPOS				 			= "listeTopos";
    public static final String ATT_LISTE_RESERVATIONS_TOPO				= "listeReservationsTopo";
    public static final String ATT_LISTE_DEMANDES_RESERVATION_TOPO		= "listeDemandesReservationTopo";

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

    @GetMapping("/liste_topos")
    public String listeTopos(Model model) {
        List<Topo> listeTopos = topoService.findAll();
        model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
        return "liste_topos";
    }

    @GetMapping("/liste_reservations_topo")
    public String listeReservationsTopo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        Long idUtilisateur = utilisateur.getId();

        List<ReservationTopo> listeReservationsTopo = topoService.listeReservationsTopo(idUtilisateur);
        model.addAttribute(ATT_LISTE_RESERVATIONS_TOPO, listeReservationsTopo);

        List<ReservationTopo> listeDemandesReservationTopo = topoService.listeDemandesReservationTopo(idUtilisateur);
        model.addAttribute(ATT_LISTE_DEMANDES_RESERVATION_TOPO, listeDemandesReservationTopo);

        return "liste_reservations_topo";
    }

    @PostMapping("traitement_demande_reservation_topo")
    public String traitementDemandeReservationTopo(HttpServletRequest request, @RequestParam(name="id") Long id, Model model) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
        topoService.enregistrerReservationTopo(id, utilisateur);
        List<Topo> listeTopos = topoService.findAll();
        model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
        return "liste_topos";
    }

    @PostMapping("traitement_reponse_demande_reservation_topo")
    public String traitementReponseDemandeReservationTopo(HttpServletRequest request, @RequestParam(name="reponseDemandeReservationTopo") StatutReservationTopo reponseDemandeReservationTopo, @RequestParam(name="id") Long idReservationTopo, Model model) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
        topoService.majReservationTopo(idReservationTopo, utilisateur, reponseDemandeReservationTopo);
        List<ReservationTopo> listeReservationsTopo = topoService.listeReservationsTopo(utilisateur.getId());
        model.addAttribute(ATT_LISTE_RESERVATIONS_TOPO, listeReservationsTopo);
        return "liste_reservations_topo";
    }

    @PostMapping("traitement_fin_reservation_topo")
    public String traitementFinReservationTopo(HttpServletRequest request, @RequestParam(name="reponseDemandeReservationTopo") StatutReservationTopo reponseDemandeReservationTopo, @RequestParam(name="id") Long idReservationTopo, Model model) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
        topoService.majReservationTopo(idReservationTopo, utilisateur, reponseDemandeReservationTopo);
        List<ReservationTopo> listeReservationsTopo = topoService.listeReservationsTopo(utilisateur.getId());
        model.addAttribute(ATT_LISTE_RESERVATIONS_TOPO, listeReservationsTopo);
        return "liste_reservations_topo";
    }
}
