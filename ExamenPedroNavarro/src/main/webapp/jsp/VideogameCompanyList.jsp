<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.io.*,java.util.*,es.salesianos.model.VideoGame,es.salesianos.model.Company"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List VideoGames from Company</title>
</head>
<body>
	<h2>VideoGames from Company</h2>
	<form action="listVideoGameCompanies" method="post">
		<input type="submit" value="See companies">
	</form>
	<br />
	<%
		List<Company> listcompany = (List<Company>) request.getAttribute("listAllCompany");
		pageContext.setAttribute("listcompany", listcompany);
	%>


	<form action="listVideogamesCompany" method="post">
		<span>Select  company:</span> <select name="company">
		</select> <br /> <input type="submit" value="Search">
			<h4>List videoGames:</h4>

			<table border="1">
				<thead>
					<tr>
						<td>Name</td>
						<td>Recomended age</td>
						<td>Launch date</td>
						<td>Console</td>
					</tr>
				</thead>
				<c:forEach items="${videogames}" var="videogames">
					<tr>
						<td><c:out value="${videogame.title}" /></td>
						<td><c:out value="${videogame.recommendedAge}" /></td>
						<td><c:out value="${videogame.launchDate}" /></td>
						<td><c:out value="${videogame.videogame.console}" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Submit">
		</form>
</body>
</html>
