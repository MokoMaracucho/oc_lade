<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/Accueil">Accueil<span class="sr-only">(current)</span></a>
            </li>

            <c:if test="${!sessionStatut}">
                <li class="nav-item">
                    <a class="nav-link" href="/utilisateur/inscription_utilisateur">Inscription <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/utilisateur/connection_utilisateur">Connection <span class="sr-only">(current)</span></a>
                </li>
            </c:if>

            <c:if test="${sessionStatut eq true}">
                <li class="nav-item">
                    <a class="nav-link" href="/utilisateur/deconnection_utilisateur">Déconnection <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ajouts </a>

                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/site/ajout_site">Ajout d'un site</a>

                        <a class="dropdown-item" href="/secteur/ajout_secteur">Ajout d'un secteur</a>

                        <a class="dropdown-item" href="/voie/ajout_voie">Ajout d'une voie</a>

                        <a class="dropdown-item" href="/longueur/ajout_longueur">Ajout d'une longueur</a>

                        <a class="dropdown-item" href="/topo/ajout_topo">Ajout d'un topo</a>
                    </div>
                </li>
            </c:if>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Listes </a>

                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/utilisateur/liste_utilisateurs">Liste des utilisateurs</a>

<!--          			<a class="dropdown-item" href="#">Liste des membres</a> -->

                    <div class="dropdown-divider"></div>

                    <a class="dropdown-item" href="/site/liste_sites">Liste des sites</a>

                    <a class="dropdown-item" href="/secteur/liste_secteurs">Liste des secteurs</a>

                    <a class="dropdown-item" href="/voie/liste_voies">Liste des voies</a>

                    <a class="dropdown-item" href="/longueur/liste_longueurs">Liste des longueurs</a>

                    <a class="dropdown-item" href="/topo/liste_topos">Liste des topos</a>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/recherche/recherche_avancee">Recherche avancée<span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" aria-label="Search">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Recherche</button>
        </form>
    </div>
</nav>

<c:if test="${sessionStatut eq true}">
    <div class="succes small p-vous-etes-connecte text-secondary">Vous êtes connecté(e) avec l'adresse : ${utilisateur.email}</div>
</c:if>