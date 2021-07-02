package com.oc.oc_lade.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.oc.oc_lade.annotation.ValidConnection;

@ValidConnection(emailFormConnection="emailFormConnection", motPasseFormConnection="motPasseFormConnection", message="La connection a échouée")
public class FormConnection {

    @NotEmpty(message="Veuillez renseigner un email.")
    @Email(message="Veuillez saisir un email valide.")
    private String emailFormConnection;

    @NotEmpty(message="Veuillez renseigner un mot-de-passe.")
    private String motPasseFormConnection;

    public String getEmailFormConnection() {
        return emailFormConnection;
    }

    public void setEmailFormConnection(String emailFormConnection) {
        this.emailFormConnection = emailFormConnection;
    }

    public String getMotPasseFormConnection() {
        return motPasseFormConnection;
    }

    public void setMotDePasseFormConnection(String motPasseFormConnection) {
        this.motPasseFormConnection = motPasseFormConnection;
    }
}