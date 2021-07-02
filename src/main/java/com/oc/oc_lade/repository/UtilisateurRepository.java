package com.oc.oc_lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    public boolean existsByEmail(String email);

    public Utilisateur getByEmail(String email);
}
