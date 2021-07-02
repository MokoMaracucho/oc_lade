package com.oc.oc_lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.oc_lade.entity.Utilisateur;
import com.oc.oc_lade.service.UtilisateurService;

public class ValidConnectionValidator implements ConstraintValidator<ValidConnection, Object> {

    private static final String ALGORYTHME_CHIFFREMENT 		= "SHA-256";

    private String emailFormConnection;
    private String motPasseFormConnection;
    private String message;

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    public void initialize(final ValidConnection annotation) {
        this.emailFormConnection = annotation.emailFormConnection();
        this.motPasseFormConnection = annotation.motPasseFormConnection();
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        Utilisateur utilisateur = new Utilisateur();
        try {
            if(utilisateurService.existsByEmail(emailFormConnection)) {
                utilisateur = utilisateurService.getByEmail(emailFormConnection);
                ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
                passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
                passwordEncryptor.setPlainDigest(false);
                String motPasseChiffreUtilisateur = utilisateur.getMotPasse();
                if (passwordEncryptor.checkPassword(motPasseFormConnection, motPasseChiffreUtilisateur)) {
                    valid = true;
                } else {
                    valid = false;
                }
            }
        } catch (final Exception ignore) { }
        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("echec_connection")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}
