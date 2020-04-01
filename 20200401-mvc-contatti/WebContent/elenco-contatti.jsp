<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Contatto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco dei contatti</title>
</head>
<body>
	<!-- recupero dalla request quello che ho "allegato" (come Attribute) nel controller -->
	<% List<Contatto> contatti = (List<Contatto>)request.getAttribute("contatti"); %>
	<h1>Elenco dei contatti (JSP)</h1>
	<h2>Numero contatti: <%= contatti.size() %></h2>
	<ul>
		<% for(Contatto c : contatti) { %>
		<li>Contatto: Nome: <%= c.getNome() %>, Cognome: <%= c.getCognome() %></li>
		<% } %>
	</ul>
</body>
</html>