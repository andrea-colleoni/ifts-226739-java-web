<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
				<td><a href="?codiceCorso=${c.codiceCorso}">${c.codiceCorso}</a> 
				(<a href="?codiceCorso=${c.codiceCorso}&mode=edit">modifica</a> | <a href="?codiceCorso=${c.codiceCorso}&mode=delete">elimina</a>)</td>
				<td>${c.titolo}</td>
				<td>${c.descrizione}</td>
				<td><fmt:formatDate type="date" value="${c.dataInizio}" /></td>
				<td><fmt:formatDate type="date" value="${c.dataFine}" /></td>
				<td>${c.monteOre}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="?mode=new">Nuovo corso</a> | <a href="./">Torna alla home</a>
</body>
</html>