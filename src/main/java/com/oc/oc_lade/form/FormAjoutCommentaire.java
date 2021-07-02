package com.oc.oc_lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutCommentaire {

    @NotEmpty(message="Veuillez écrire un commentaire.")
    @Size(min=2, max=300, message="Le commentaire n'a pas la longueur appropriée.")
    private String commentaire;

    private Long idSite;

    public FormAjoutCommentaire() {
    }

    public FormAjoutCommentaire(String commentaire, Long idSite) {
        this.commentaire = commentaire;
        this.idSite = idSite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Long getIdSite() {
        return idSite;
    }

    public void setIdSite(Long idSite) {
        this.idSite = idSite;
    }

    @Override
    public String toString() {
        return "FormAjoutCommentaire{" +
                "commentaire='" + commentaire + '\'' +
                ", idSite=" + idSite +
                '}';
    }
}
