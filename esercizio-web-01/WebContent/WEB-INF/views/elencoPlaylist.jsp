<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Playlist" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco delle playlist</title>
</head>
<body>
<% List<Playlist> playlist = (List<Playlist>)request.getAttribute("playlist"); %>

<h2>Elenco delle playlist</h2>
<table style="border: 1px solid black;width: 100%;">
	<tr>
		<td>ID</td>
		<td>Nome della playlist</td>
	</tr>

	<% for(Playlist p : playlist) { %>
	<tr>
		<td><a href="./brani?playlist=<%= p.getId() %>"><%= p.getId() %></a></td> 
		<td><%= p.getNome() %></td>
	</tr>
	<% } %>
</table>
<a href="./brani">Vai all'elenco brani</a>
</body>
</html>