<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corso ${corso.codiceCorso}</title>
</head>
<body>
	<h1>Corso ${corso.codiceCorso}</h1>
	<p>Titolo: <strong>${corso.titolo}</strong></p>
	<p>Descrizione: <strong>${corso.descrizione}</strong></p>
	<p>Data inizio: <strong><fmt:formatDate pattern="yyyy-MM-dd" value="${corso.dataInizio}" /></strong></p>
	<p>Data fine: <strong>${corso.dataFine}</strong></p>
	<p>Monte ore: <strong>${corso.monteOre}</strong></p>
	<a href="?codiceCorso=${ corso.codiceCorso }&mode=edit">Modifica</a>
	<br>
	<h2>Studenti iscritti</h2>
	<table border="1" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>E-mail</td>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Num. telefono</td>
		</tr>
		<c:forEach var="s" items="${ corso.iscritti }">
			<tr>
				<td>${ s.email }</td>
				<td>${ s.nome }</td>
				<td>${ s.cognome }</td>
				<td>${ s.numeroTelefono }</td>
			</tr>
		</c:forEach>
	</table>
	<h2>Elenco delle lezioni</h2>
	<table border="1" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>ID</td>
			<td>Data</td>
			<td>Argomento</td>
			<td>Note</td>
		</tr>
		<c:forEach var="l" items="${ corso.lezioni }">
			<tr>
				<td>${ l.id }</td>
				<td>${ l.dataLezione }</td>
				<td>${ l.argomento }</td>
				<td>${ l.note }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="./corsi">Torna all'elenco</a>
</body>
</html>