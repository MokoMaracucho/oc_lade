package com.oc.oc_lade.repository;

import com.oc.oc_lade.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Longueur;

import java.util.List;

@Repository
public interface LongueurRepository extends JpaRepository<Longueur, Long> {

    @Query(value="SELECT * FROM db_lade.longueur WHERE nom = :nom AND region = :region", nativeQuery=true)
    List<Longueur> findByNomAndRegion(@Param("nom") String nom, @Param("region") String region);
}
