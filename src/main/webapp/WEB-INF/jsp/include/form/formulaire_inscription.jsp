<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formulaire_inscription" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formInscription">
		<h1 class="font-weight-bold text-light">INSCRIPTION</h1>

		<div class="form-group">
	    	<label for="prenom" class="form-label-color">Prénom</label>
			<form:errors path="prenom" cssClass="small text-warning form-error" />
			<form:input path="prenom" cssClass="form-control" />
		</div>

		<div class="form-group">
	    	<label for="nom" class="form-label-color">Nom</label>
			<form:errors path="nom" cssClass="small text-warning form-error" />
			<form:input path="nom" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="email" class="text-light">Émail</label>
			<form:errors path="email" cssClass="small text-warning form-error" />
			<form:input path="email" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="motPasse" class="text-light">Mot-de-passe</label>
			<form:errors path="motPasse" cssClass="small text-warning form-error" />
			<form:password path="motPasse" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="confirmationMotPasse" class="text-light">Confirmation mot-de-passe</label>
			<form:errors path="confirmationMotPasse" cssClass="small text-warning form-errorg" />
			<form:password path="confirmationMotPasse" cssClass="form-control" />
		</div>

		<button type="submit" class="btn btn-success">S'inscrire</button>
	</form:form>
</div>