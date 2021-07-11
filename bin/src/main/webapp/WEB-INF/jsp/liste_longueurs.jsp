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

	<title>Liste des longueurs | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>

	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>

			<h1 class="font-weight-bold text-light">LISTE DES LONGUEURS</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>VOIE</th>
					<th>COTATION</th>
					<th>CRÉATEUR LONGUEUR</th>
					<!--<th>MISE-À-JOUR</th>-->
					<!--<th>SUPRESSION</th>-->
				</tr>

				<c:forEach var="longueur" items="${listeLongueurs}">

					<c:url var="lienMaj" value="/longueur/maj_longueur">
		       			<c:param name="id" value="${longueur.id}" />
		      		</c:url>

				    <c:url var="lienSuppression" value="/longueur/supprimer_longueur">
				        <c:param name="id" value="${longueur.id}" />
				    </c:url>

					<tr class="small">
						<td>${longueur.id}</td>
						<td>${longueur.nom}</td>
						<td>${longueur.voie.nom}</td>
						<td>${longueur.cotation}</td>
						<td>${longueur.utilisateur.prenom} ${longueur.utilisateur.nom}</td>
<!-- 						<td> -->
<%-- 							<form action="maj_voie" method="post"> --%>
<%-- 								<input type="hidden" name="id" value="${longueur.id}" /> --%>
<!-- 								<button class="btn btn-success">Mettre-à-jour</button> -->
<%-- 							</form> --%>
<!-- 						</td> -->
						<!--<td>
							<form action="supprimer_longueur" method="post">
								<input type="hidden" name="id" value="${longueur.id}" />
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
