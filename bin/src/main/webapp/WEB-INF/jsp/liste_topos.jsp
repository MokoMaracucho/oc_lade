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

	<title>Liste des topos | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>

	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>

			<h1 class="font-weight-bold text-light">LISTE DES TOPOS</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>REGION</th>
					<th>DESCRIPTION</th>
					<th>PROPRIÉTAIRE</th>
					<th>DATE PARUTION</th>
					<c:if test="${topo.disponibilite && topo.utilisateur.id != utilisateur.id}">
						<th>DISPONIBILITÉ</th>
					</c:if>
					<th>SUPRESSION</th>
				</tr>

				<c:forEach var="topo" items="${listeTopos}">
						<tr class="small">
							<td>${topo.id}</td>
							<td>${topo.nom}</td>
							<td>${topo.region}</td>
							<td>${topo.description}</td>
							<td>${topo.utilisateur.prenom} ${topo.utilisateur.nom}</td>
							<td>${topo.dateParution}</td>
							<c:if test="${topo.disponibilite && topo.utilisateur.id != utilisateur.id}">
								<td>
									<form action="traitement_demande_reservation_topo" method="post">
										<input type="hidden" name="id" value="${topo.id}" />
										<button class="btn btn-success">Demande de réservation</button>
									</form>
								</td>
							</c:if>
							<td>
								<form action="supprimer_topo" method="post">
									<input type="hidden" name="id" value="${topo.id}" />
									<button class="btn btn-danger">Supprimer</button>
								</form>
							</td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
