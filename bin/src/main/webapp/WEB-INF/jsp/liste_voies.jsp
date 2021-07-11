<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<%@ page isELIgnored="false" %>
	<meta charset="UTF-8">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<title>Liste des voies | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>

	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>

			<h1 class="font-weight-bold text-light">LISTE DES VOIES</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>SECTEUR</th>
					<th>VOIE ÉQUIPÉE</th>
					<th>COTATION</th>
					<th>CRÉATEUR VOIE</th>
<!-- 					<th>MISE-À-JOUR</th> -->
					<!--<th>SUPRESSION</th>-->
				</tr>

				<c:forEach var="voie" items="${listeVoies}">
					<tr class="small">
						<td>${voie.id}</td>
						<td>${voie.nom}</td>
						<td>${voie.secteur.nom}</td>
						<td>${voie.equipe ? "Oui" : "Non"}</td>
						<td>${voie.cotation}</td>
						<td>${voie.utilisateur.prenom} ${voie.utilisateur.nom}</td>
<!-- 						<td> -->
<%-- 							<form action="maj_voie" method="post"> --%>
<%-- 								<input type="hidden" name="id" value="${voie.id}" /> --%>
<!-- 								<button class="btn btn-success">Mettre-à-jour</button> -->
<%-- 							</form> --%>
<!-- 						</td> -->
						<!--<td>
							<form action="supprimer_voie" method="post">
								<input type="hidden" name="id" value="${voie.id}" />
								<button class="btn btn-danger">Supprimer</button>
							</form>
						</td>-->
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
