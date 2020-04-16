<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Corsi</title>
</head>
<body>
	<h1>Elenco corsi</h1>
	<p>Ho trovato ${corsi.size()} corsi.</p>
	<table border="1" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td>Codice</td>
			<td>Titolo</td>
			<td>Descrizione</td>
			<td>Data inizio</td>
			<td>Data fine</td>
			<td>Monte ore</td>
		</tr>
		<c:forEach var="c" items="${corsi}">
			<tr>
				<td>${c.codiceCorso}</td>
				<td>${c.titolo}</td>
				<td>${c.descrizione}</td>
				<td>${c.dataInizio}</td>
				<td>${c.dataFine}</td>
				<td>${c.monteOre}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>