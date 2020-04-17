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
	<h1>
		<c:if test="${ mode == 'new'}">Nuovo</c:if>
		<c:if test="${ mode != 'new'}">Modifica</c:if>
		corso ${corso.codiceCorso}
	</h1>
	<!-- racchiudere tutti gli elementi di INPUT in un form specificando: action, method -->
	<!--  action => controller -->
	<!--  method => metodo dentro al controller -->
	<form action="./corsi" method="post">
		<!--  devo dare un nome (attributo name) a tutti i campi che voglio trasmettere al server -->
		<c:if test="${ mode == 'new'}">
			<p>Codice corso: <input type="text" value="${ corso.codiceCorso }" name="codiceCorso" /></p>
		</c:if>
		<c:if test="${ mode != 'new'}">
			<input type="hidden" value="${ corso.codiceCorso }" name="codiceCorso" />
		</c:if>
		
		<input type="hidden" value="${ corso.codiceCorso }" name="codiceCorso" />
		<p>Titolo: <input type="text" value="${corso.titolo}" name="titolo" /></p>
		
		<p>Descrizione: <textarea name="descrizione">${corso.descrizione}</textarea></p>
		
		<fmt:formatDate type="date" value="${corso.dataInizio}" pattern="yyyy-MM-dd" var="dataInizio" />
		<p>Data inizio: <input type="date" value="${dataInizio}" name="dataInizio" /></p>
		
		<fmt:formatDate type="date" value="${corso.dataFine}" pattern="yyyy-MM-dd" var="dataFine" />
		<p>Data fine: <input type="date" value="${dataFine}" name="dataFine" /></p>
		
		<p>Monte ore: <input type="number" value="${corso.monteOre}" name="monteOre" /></p>
		
		<!-- aggiungo anche un pulsante SUMBIT per innescare l'invio del form al server -->
		<input type="submit" value="Salva il corso" />
	</form>
	<a href="./corsi">Torna all'elenco</a>
</body>
</html>