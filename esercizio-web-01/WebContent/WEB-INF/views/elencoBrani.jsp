<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Brano" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco dei brani</title>
</head>
<body>
<% List<Brano> brani = (List<Brano>)request.getAttribute("brani"); %>

<h2>Elenco dei brani</h2>
<table style="border: 1px solid black;width: 100%;">
	<tr>
		<td>ID</td>
		<td>Titolo</td>
		<td>Autore</td>
		<td>Genere</td>
		<td>Durata (min.)</td>
	</tr>
	<% for(Brano b : brani) { %>
	<tr>
		<td><%= b.getId() %></td> 
		<td><%= b.getTitolo() %></td>
		<td><%= b.getAutore() %></td>
		<td><%= b.getGenere() %></td>
		<td><%= b.getDurataInMinuti() %></td>
	</tr>
	<% } %>
</table>
<a href="./playlists">Vai all'elenco delle playlist</a>
</body>
</html>