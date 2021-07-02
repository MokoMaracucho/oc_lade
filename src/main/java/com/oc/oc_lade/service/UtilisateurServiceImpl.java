package com.oc.oc_lade.service;

import com.oc.oc_lade.entity.Privilege;
import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.exception.ResourceNotFoundException;
import com.oc.oc_lade.form.FormInscription;
import com.oc.oc_lade.form.FormMajUtilisateur;
import com.oc.oc_lade.repository.UtilisateurRepository;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private static final String ALGORYTHME_CHIFFREMENT 		= "SHA-256";

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    @Transactional
    public void save(FormInscription formInscription) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(formInscription.getPrenom());
        utilisateur.setNom(formInscription.getNom());
        utilisateur.setEmail(formInscription.getEmail());
        String motPasse = formInscription.getMotPasse();
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
        passwordEncryptor.setPlainDigest(false);
        String motPasseChiffre = passwordEncryptor.encryptPassword(motPasse);
        utilisateur.setMotPasse(motPasseChiffre);
        utilisateur.setPrivilege(formInscription.getPrivilege());
        List<Utilisateur> listeUtilisateurs = utilisateurRepository.findAll();
        if(listeUtilisateurs.isEmpty()) {
            utilisateur.setPrivilege(Privilege.MEMBRE);
        } else {
            utilisateur.setPrivilege(Privilege.UTILISATEUR);
        }
        utilisateur.setDateInscription(new Timestamp(System.currentTimeMillis()));
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur getById(Long id) throws ResourceNotFoundException {
        return utilisateurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public boolean existsByEmail(String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    @Override
    public Utilisateur getByEmail(String email) {
        return utilisateurRepository.getByEmail(email);
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public FormMajUtilisateur formulaireMajUtilisateur(Utilisateur utilisateur) {
        FormMajUtilisateur formMajUtilisateur = new FormMajUtilisateur();
        formMajUtilisateur.setPrenomFormMajUtilisateur(utilisateur.getPrenom());
        formMajUtilisateur.setNomFormMajUtilisateur(utilisateur.getNom());
//		forMajUtilisateur.setEmailFormMajUtilisateur(utilisateur.getEmailUtilisateur());
        if(utilisateur.getPrivilege() == Privilege.UTILISATEUR) {
            formMajUtilisateur.setMembreFormMajUtilisateur(false);
        } else {
            formMajUtilisateur.setMembreFormMajUtilisateur(true);
        }
        return formMajUtilisateur;
    }

    @Override
    public void updateUtilisateur(FormMajUtilisateur formMajUtilisateur) {
        Long idUtilisateur = formMajUtilisateur.getIdFormMajUtilisateur();
        Utilisateur utilisateur = utilisateurRepository.getById(idUtilisateur);
        if(utilisateur.getPrenom() != formMajUtilisateur.getPrenomFormMajUtilisateur()) {
            utilisateur.setPrenom(formMajUtilisateur.getPrenomFormMajUtilisateur());
        }
        if(utilisateur.getNom() != formMajUtilisateur.getNomFormMajUtilisateur()) {
            utilisateur.setNom(formMajUtilisateur.getNomFormMajUtilisateur());
        }
//		if(utilisateur.getEmailUtilisateur() != formMajUtilisateur.getEmailFormMajUtilisateur()) {
//			utilisateur.setEmailUtilisateur(formMajUtilisateur.getEmailFormMajUtilisateur());
//			String emailMaj = formMajUtilisateur.getEmailFormMajUtilisateur();
//			utilisateurRepository.majEmailUtilisateur(idUtilisateur, emailMaj);
//		}
        if(formMajUtilisateur.getMembreFormMajUtilisateur() == null) {
            formMajUtilisateur.setMembreFormMajUtilisateur(false);
        }
        if(formMajUtilisateur.getMembreFormMajUtilisateur() == true) {
            utilisateur.setPrivilege(Privilege.MEMBRE);
        } else {
            utilisateur.setPrivilege(Privilege.UTILISATEUR);
        }
        utilisateurRepository.save(utilisateur);
    }
}
