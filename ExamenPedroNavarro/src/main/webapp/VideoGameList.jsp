<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,es.salesianos.model.VideoGame"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VideoGames</title>
</head>
<body>
	<form action="OrderByReleaseDate" method="post">
		<input type="submit" value="order list by release date">
	</form>
	<form action="dataGames" method="post">
		<table border="1">
			<thead>
				<tr>
					<td>Title</td>
					<td>remomendedAge</td>
					<td>launchDate</td>
				</tr>
			</thead>
			<c:forEach var="videogames" items="${listAllVideoGame}">
				<tr>
					<td><c:out value="${videogames.title}" /></td>
					<td><c:out value="${videogames.recommendedAge}" /></td>
					<td><c:out value="${videogames.launchDate}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit table">
	</form>
</body>
</html>