package com.oc.oc_lade.repository;

import java.util.List;

import com.oc.oc_lade.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Voie;

@Repository
public interface VoieRepository extends JpaRepository<Voie, Long> {

    Voie getByNom(String nomVoie);

    @Query(value="SELECT * FROM voie WHERE nom = :nom AND region = :region", nativeQuery=true)
    List<Voie> findByNomAndRegion(@Param("nom") String nom, @Param("region") String region);

    @Query(value="SELECT * FROM voie WHERE nom = :nom", nativeQuery=true)
    List<Voie> findByNom(@Param("nom") String nom);
}
