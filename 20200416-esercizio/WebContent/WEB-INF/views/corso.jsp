<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corso ${ corso.codiceCorso }</title>
</head>
<body>
<h1>Corso ${corso.codiceCorso}</h1>
<p>Titolo: <strong>${corso.titolo}</strong></p>
<p>Descrizione: <strong>${corso.descrizione}</strong></p>
<br>
<a href="./corsi">Torna all'elenco</a>
</body>
</html>