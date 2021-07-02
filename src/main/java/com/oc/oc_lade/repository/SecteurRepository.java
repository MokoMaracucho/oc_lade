package com.oc.oc_lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Secteur;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Long> {

    Secteur getByNom(String nomSecteur);
}
