package com.oc.oc_lade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Privilege;
import com.oc.oc_lade.entity.Topo;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Long> {

    @Query(value="SELECT * FROM topo WHERE nom = :nomRecherche", nativeQuery=true)
    List<Topo> rechercheNomTopo(@Param("nomRecherche") String nomRecherche);

    @Query(value="SELECT * FROM topo WHERE nom = :regionRecherche", nativeQuery=true)
    List<Topo> rechercheRegionTopo(@Param("regionRecherche") String regionRecherche);

    @Query(value="SELECT * FROM topo WHERE nom = :nomRecherche AND region = :regionRecherche", nativeQuery=true)
    List<Topo> rechercheNomRegionTopo(@Param("nomRecherche") String nomRecherche, @Param("regionRecherche") String regionRecherche);

    //@Query(value="UPDATE topo SET disponibilite = :disponibilite WHERE id = :id", nativeQuery=true)
    //int majDisponibiliteTopo(@Param("id") Long id, @Param("disponibilite") Boolean disponibilite);
}
