package com.oc.oc_lade.repository;

import com.oc.oc_lade.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Secteur;

import java.util.List;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Long> {

    Secteur getByNom(String nomSecteur);

    @Query(value="SELECT * FROM secteur WHERE nom = :nom AND region = :region", nativeQuery=true)
    List<Secteur> findByNomAndRegion(@Param("nom") String nom, @Param("region") String region);

    @Query(value="SELECT * FROM secteur WHERE nom = :nom", nativeQuery=true)
    List<Secteur> findByNom(@Param("nom") String nom);
}
