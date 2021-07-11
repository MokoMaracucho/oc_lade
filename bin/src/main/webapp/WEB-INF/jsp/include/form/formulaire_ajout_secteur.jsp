<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formulaire_ajout_secteur" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formAjoutSecteur">
		<h1 class="font-weight-bold text-light">AJOUT D'UN SECTEUR</h1>

		<c:choose>
			<c:when test="${!empty listeSites}">
				<div class="form-group">
					<label for="nom" class="form-label-color">Nom du secteur</label>
					<form:errors path="nom" cssClass="small text-warning form-error" />
					<form:input path="nom" cssClass="form-control" />
				</div>

				<div class="form-group">
		    		<label for="nomSite" class="form-label-color">Sélectionnez un site</label>
					<form:errors path="nomSite" cssClass="small text-warning form-error" />
					<form:select path="nomSite" class="custom-select mr-sm-2">
						<form:option value="" />
						<c:forEach  var="site" items="${listeSites}">
							<form:option value="${site.nom}" />
						</c:forEach>
					</form:select>
				</div>

				<button type="submit" class="btn btn-success">Ajouter le secteur</button>
			</c:when>

			<c:otherwise>
				<p class="form-label-color">Il n'existe aucun site.</p>
			</c:otherwise>
		</c:choose>
	</form:form>
</div>