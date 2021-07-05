package com.oc.oc_lade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.ReservationTopo;

@Repository("reservationTopoRepository")
public interface ReservationTopoRepository extends JpaRepository<ReservationTopo, Long> {

    @Query(value="SELECT * FROM reservation_topo WHERE id IN ( SELECT id FROM topo WHERE utilisateur_id = :idProprietaire)", nativeQuery=true)
    List<ReservationTopo> findAllByIdProprietaireTopo(@Param("idProprietaire") Long idProprietaire);

    @Query(value="SELECT * FROM reservation_topo WHERE utilisateur_id = :idDemandeur", nativeQuery=true)
    List<ReservationTopo> findAllByIdDemandeurReservationTopo(@Param("idDemandeur") Long idDemandeur);
}
