package com.oc.oc_lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oc.oc_lade.service.UtilisateurService;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

    protected String email;
    protected String message;

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    public void initialize(EmailUnique annotation) {
        this.email = annotation.value();
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        boolean valid = true;
        try {
            valid = !utilisateurService.existsByEmail(email);
        } catch (final Exception ignore) { }
        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}