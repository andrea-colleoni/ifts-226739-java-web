<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corso ${corso.codiceCorso}</title>
</head>
<body>
	<h1>Corso ${corso.codiceCorso}</h1>
	
	<p>Titolo: <input type="text" value="${corso.titolo}" /></p>
	<p>Descrizione: <input type="text" value="${corso.descrizione}" /></p>
	<p>Data inizio: <input type="date" value="${corso.dataInizio}" /></p>
	<p>Data fine: <input type="date" value="${corso.dataFine}" /></p>
	<p>Monte ore: <input type="number" value="${corso.monteOre}" /></p>
	
	<a href="./corsi">Torna all'elenco</a>
</body>
</html>