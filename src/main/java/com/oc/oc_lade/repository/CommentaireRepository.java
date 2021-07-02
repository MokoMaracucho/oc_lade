package com.oc.oc_lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Commentaire;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    @Query(value="SELECT * FROM commentaire WHERE site_id = :id", nativeQuery=true)
    List<Commentaire> findAllByIdSite(@Param("id") Long id);
}
