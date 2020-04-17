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
	<h1>Modifica corso ${corso.codiceCorso}</h1>
	<!-- racchiudere tutti gli elementi di INPUT in un form specificando: action, method -->
	<!--  action => controller -->
	<!--  method => metodo dentro al controller -->
	<form action="./corsi" method="post">
		<!--  devo dare un nome (attributo name) a tutti i campi che voglio trasmettere al server -->
		<input type="hidden" value="${ corso.codiceCorso }" name="codiceCorso" />
		<p>Titolo: <input type="text" value="${corso.titolo}" name="titolo" /></p>
		<p>Descrizione: <input type="text" value="${corso.descrizione}" name="descrizione" /></p>
		<p>Data inizio: <input type="date" value="${corso.dataInizio}" name="dataInizio" /></p>
		<p>Data fine: <input type="date" value="${corso.dataFine}" name="dataFine" /></p>
		<p>Monte ore: <input type="number" value="${corso.monteOre}" name="monteOre" /></p>
		
		<!-- aggiungo anche un pulsante SUMBIT per innescare l'invio del form al server -->
		<input type="submit" value="Salva il corso" />
	</form>
	<a href="./corsi">Torna all'elenco</a>
</body>
</html>