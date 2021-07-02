package com.oc.oc_lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String motPasseFormInscription;
    private String confirmationMotPasseFormInscription;
    private String message;

    @Override
    public void initialize(final FieldMatch annotation) {
        this.motPasseFormInscription = annotation.motPasseFormInscription();
        this.confirmationMotPasseFormInscription = annotation.confirmationMotPasseFormInscription();
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        try {
            final Object motPasseFormInscriptionObj 				= BeanUtils.getProperty(value, motPasseFormInscription);
            final Object confirmationMotPasseFormInscriptionObj 	= BeanUtils.getProperty(value, confirmationMotPasseFormInscription);
            valid = motPasseFormInscriptionObj == null && confirmationMotPasseFormInscriptionObj == null || motPasseFormInscriptionObj != null && motPasseFormInscriptionObj.equals(confirmationMotPasseFormInscriptionObj);
        } catch (final Exception ignore) { }
        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(motPasseFormInscription)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        return valid;
    }
}
