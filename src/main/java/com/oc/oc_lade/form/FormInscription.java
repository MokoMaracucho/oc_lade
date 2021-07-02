package com.oc.oc_lade.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.oc.oc_lade.annotation.EmailUnique;
import com.oc.oc_lade.annotation.FieldMatch;
import com.oc.oc_lade.entity.Privilege;

@FieldMatch(motPasseFormInscription="motPasseFormInscription", confirmationMotPasseFormInscription="confirmationMotPasseFormInscription", message="Les mots-de-passe doivent être identiques.")
public class FormInscription {

    @NotEmpty(message="Veuillez renseigner un prénom.")
    @Size(min=2, max=30, message="Le prénom n'a pas la longueur appropriée.")
    @Pattern(regexp="^[a-zA-Z -]+$", message="Le prénom n'est pas valide.")
    private String prenomFormInscription;

    @NotEmpty(message="Veuillez renseigner un nom.")
    @Size(min=2, max=30, message="Le nom n'a pas la longueur appropriée.")
    @Pattern(regexp="^[a-zA-Z -]+$", message="Le nom n'est pas valide.")
    private String nomFormInscription;

    @NotEmpty(message="Veuillez renseigner un email.")
    @Email(message="Veuillez saisir un email valide.")
    @EmailUnique(value="emailFormInscription")
    private String emailFormInscription;

    @NotEmpty(message="Veuillez renseigner un mot-de-passe.")
    @Size(min=5, max=30, message="L'email n'a pas la longueur appropriée.")
    @Pattern(regexp="^[a-zA-Z0-9- @^_!\\\"#$%&'()*+,./:;{}<>=|~?]+$", message="Le mot-de-passe n'est pas valide.")
    private String motPasseFormInscription;

    @NotEmpty(message="Veuillez comfirmer le mot-de-passe.")
    private String confirmationMotPasseFormInscription;

    private Privilege privilege;

    public FormInscription() {
    }

    public FormInscription(String nom, String email, String motPasse, String confirmationMotPasse, Privilege privilege) {
        this.nomFormInscription = nom;
        this.emailFormInscription = email;
        this.motPasseFormInscription = motPasse;
        this.confirmationMotPasseFormInscription = confirmationMotPasse;
        this.privilege = privilege;
    }

    public String getPrenom() {
        return prenomFormInscription;
    }

    public void setPrenom(String prenom) {
        this.prenomFormInscription = prenom;
    }

    public String getNom() {
        return nomFormInscription;
    }

    public void setNom(String nom) {
        this.nomFormInscription = nom;
    }

    public String getEmail() {
        return emailFormInscription;
    }

    public void setEmail(String email) {
        this.emailFormInscription = email;
    }

    public String getMotPasse() {
        return motPasseFormInscription;
    }

    public void setMotPasse(String motPasse) {
        this.motPasseFormInscription = motPasse;
    }

    public String getConfirmationMotPasse() {
        return confirmationMotPasseFormInscription;
    }

    public void setConfirmationMotPasse(String confirmationMotPasse) {
        this.confirmationMotPasseFormInscription = confirmationMotPasse;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "FormInscription{" +
                "prenom='" + prenomFormInscription + '\'' +
                ", nom='" + nomFormInscription + '\'' +
                ", email='" + emailFormInscription + '\'' +
                ", motPasse='" + motPasseFormInscription + '\'' +
                ", confirmationMotPasse='" + confirmationMotPasseFormInscription + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
