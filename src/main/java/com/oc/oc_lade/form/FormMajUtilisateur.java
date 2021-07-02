package com.oc.oc_lade.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.oc.oc_lade.annotation.EmailUnique;
import com.oc.oc_lade.annotation.FieldMatch;

@FieldMatch(motPasseFormInscription="motPasseFormMajUtilisateur", confirmationMotPasseFormInscription="confirmationMotPasseFormMajUtilisateur", message="Les mots-de-passe doivent être identiques.")
public class FormMajUtilisateur {

    private Long idFormMajUtilisateur;

    @Size(min=2, max=30, message="Le prénom n'a pas la longueur appropriée.")
    @Pattern(regexp="^[a-zA-Z -]+$", message="Le prénom n'est pas valide.")
    private String prenomFormMajUtilisateur;

    @Size(min=2, max=30, message="Le nom n'a pas la longueur appropriée.")
    @Pattern(regexp="^[a-zA-Z -]+$", message="Le nom n'est pas valide.")
    private String nomFormMajUtilisateur;

    @Email(message="Veuillez saisir un email valide.")
    @EmailUnique(value="emailFormInscription")
    private String emailFormMajUtilisateur;

    @Size(min=5, max=30, message="L'email n'a pas la longueur appropriée.")
    @Pattern(regexp="^[a-zA-Z0-9- @^_!\\\"#$%&'()*+,./:;{}<>=|~?]+$", message="Le mot-de-passe n'est pas valide.")
    private String motPasseFormMajUtilisateur;

    private String confirmationMotPasseFormMajUtilisateur;

    private Boolean membreFormMajUtilisateur;

    public FormMajUtilisateur() {
    }

    public FormMajUtilisateur(String prenomFormMajUtilisateur, String nomFormMajUtilisateur, String emailFormMajUtilisateur, String motPasseFormMajUtilisateur, String confirmationMotPasseFormMajUtilisateur, Boolean membreFormMajUtilisateur) {
        this.prenomFormMajUtilisateur = prenomFormMajUtilisateur;
        this.nomFormMajUtilisateur = nomFormMajUtilisateur;
        this.emailFormMajUtilisateur = emailFormMajUtilisateur;
        this.motPasseFormMajUtilisateur = motPasseFormMajUtilisateur;
        this.confirmationMotPasseFormMajUtilisateur = confirmationMotPasseFormMajUtilisateur;
        this.membreFormMajUtilisateur = membreFormMajUtilisateur;
    }

    public FormMajUtilisateur(Long idFormMajUtilisateur, String prenomFormMajUtilisateur, String nomFormMajUtilisateur, String emailFormMajUtilisateur, String motPasseFormMajUtilisateur, String confirmationMotPasseFormMajUtilisateur, Boolean membreFormMajUtilisateur) {
        this.idFormMajUtilisateur = idFormMajUtilisateur;
        this.prenomFormMajUtilisateur = prenomFormMajUtilisateur;
        this.nomFormMajUtilisateur = nomFormMajUtilisateur;
        this.emailFormMajUtilisateur = emailFormMajUtilisateur;
        this.motPasseFormMajUtilisateur = motPasseFormMajUtilisateur;
        this.confirmationMotPasseFormMajUtilisateur = confirmationMotPasseFormMajUtilisateur;
        this.membreFormMajUtilisateur = membreFormMajUtilisateur;
    }

    public Long getIdFormMajUtilisateur() {
        return idFormMajUtilisateur;
    }

    public void setIdFormMajUtilisateur(Long idFormMajUtilisateur) {
        this.idFormMajUtilisateur = idFormMajUtilisateur;
    }

    public String getPrenomFormMajUtilisateur() {
        return prenomFormMajUtilisateur;
    }

    public void setPrenomFormMajUtilisateur(String prenomFormMajUtilisateur) {
        this.prenomFormMajUtilisateur = prenomFormMajUtilisateur;
    }

    public String getNomFormMajUtilisateur() {
        return nomFormMajUtilisateur;
    }

    public void setNomFormMajUtilisateur(String nomFormMajUtilisateur) {
        this.nomFormMajUtilisateur = nomFormMajUtilisateur;
    }

    public String getEmailFormMajUtilisateur() {
        return emailFormMajUtilisateur;
    }

    public void setEmailFormMajUtilisateur(String emailFormMajUtilisateur) {
        this.emailFormMajUtilisateur = emailFormMajUtilisateur;
    }

    public String getMotPasseFormMajUtilisateur() {
        return motPasseFormMajUtilisateur;
    }

    public void setMotPasseFormMajUtilisateur(String motPasseFormMajUtilisateur) {
        this.motPasseFormMajUtilisateur = motPasseFormMajUtilisateur;
    }

    public String getConfirmationMotPasseFormMajUtilisateur() {
        return confirmationMotPasseFormMajUtilisateur;
    }

    public void setConfirmationMotPasseFormMajUtilisateur(String confirmationMotPasseFormMajUtilisateur) {
        this.confirmationMotPasseFormMajUtilisateur = confirmationMotPasseFormMajUtilisateur;
    }

    public Boolean getMembreFormMajUtilisateur() {
        return membreFormMajUtilisateur;
    }

    public void setMembreFormMajUtilisateur(Boolean membreFormMajUtilisateur) {
        this.membreFormMajUtilisateur = membreFormMajUtilisateur;
    }

    @Override
    public String toString() {
        return "FormMajUtilisateur{" +
                "idFormMajUtilisateur=" + idFormMajUtilisateur +
                ", prenomFormMajUtilisateur='" + prenomFormMajUtilisateur + '\'' +
                ", nomFormMajUtilisateur='" + nomFormMajUtilisateur + '\'' +
                ", emailFormMajUtilisateur='" + emailFormMajUtilisateur + '\'' +
                ", motPasseFormMajUtilisateur='" + motPasseFormMajUtilisateur + '\'' +
                ", confirmationMotPasseFormMajUtilisateur='" + confirmationMotPasseFormMajUtilisateur + '\'' +
                ", membreFormMajUtilisateur=" + membreFormMajUtilisateur +
                '}';
    }
}
