package com.oc.oc_lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Site;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

    Site getByNom(String nomSite);

    @Query(value="SELECT * FROM site WHERE nom = :nom AND region = :region", nativeQuery=true)
    List<Site> findByNomAndRegion(@Param("nom") String nom, @Param("region") String region);

    @Query(value="SELECT * FROM site WHERE nom = :nom", nativeQuery=true)
    List<Site> findByNom(@Param("nom") String nom);

    @Query(value="SELECT * FROM site WHERE region = :region", nativeQuery=true)
    List<Site> findByRegion(@Param("region") String region);
}
