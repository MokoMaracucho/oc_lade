package com.oc.oc_lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.oc_lade.entity.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
}
