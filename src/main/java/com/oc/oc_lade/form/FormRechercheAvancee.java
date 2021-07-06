package com.oc.oc_lade.form;

public class FormRechercheAvancee {

    private String nom;

    private String region;

    public FormRechercheAvancee() {
    }

    public FormRechercheAvancee(String nom, String region) {
        this.nom = nom;
        this.region = region;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "FormRechercheAvancee{" +
                "nom='" + nom + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
