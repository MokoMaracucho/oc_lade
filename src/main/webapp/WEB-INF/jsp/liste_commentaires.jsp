<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <style>
	html { background-color: grey; }
  </style>
	<%@ page isELIgnored="false" %>
	<meta charset="UTF-8">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<title>Liste des commentaires | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>

	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>

			<h1 class="font-weight-bold text-light">LISTE DES COMMENTAIRES</h1>

			<h6 class="font-weight-bold text-light">Site : ${site.nom}</h6>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>COMMENTAIRE</th>
					<th>AUTEUR</th>
					<c:if test="${utilisateur.privilege eq 'MEMBRE'}">
						<th>SUPPRIMER</th>
					</c:if>
				</tr>

				<c:forEach var="commentaire" items="${listeCommentairesByIdSite}">

					<tr class="small">
						<td>${commentaire.id}</td>
						<td>${commentaire.commentaire}</td>
						<td>${commentaire.utilisateur.prenom} ${commentaire.utilisateur.nom}</td>
						<c:if test="${utilisateur.privilege eq 'MEMBRE'}">
							<td>
								<form action="suppression_commentaire_par_id" method="post">
									<input type="hidden" name="id" value="${commentaire.id}" />
									<input type="hidden" name="idSite" value="${site.id}" />
									<input type="submit" class="btn btn-danger" value="Supprimer le commentaire" />
								</form>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="div-container">
			<div class="container">
				<div class="row">
					<div class="col-md-6 offset-md-3">
						<div class="container">
							<form:form action="traitement_formulaire_ajout_commentaire" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formAjoutCommentaire">
								<h1 class="font-weight-bold text-light">COMMENTER LE SITE</h1>

								<div class="form-group">
									<label for="commentaire" class="form-label-color">Commentaire</label>
									<form:errors path="commentaire" cssClass="small text-warning form-error" />
						        	<form:textarea path="commentaire" class="form-control" />
								</div>

								<input type="hidden" name="idSite" value="${site.id}" />

								<button type="submit" class="btn btn-success">Commenter le site</button>
							</form:form>
						</div>
					</div>
	  			</div>
		    </div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
