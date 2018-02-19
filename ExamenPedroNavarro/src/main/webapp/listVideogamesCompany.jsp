<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.VideoGame,es.salesianos.model.Company"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Videogames from Company</title>
</head>
<body>

	<h2>Videogames from Company</h2>

	<form action="listDropDownCompaniesVideogame" method="post">
		<input type="submit" value="See companies">
	</form>
	<br/>
	<%
		List<Company> companies = (List<Company>) request.getAttribute("listAllCompanies");
		pageContext.setAttribute("companies", companies);
	%>


	<form action="listVideogamesCompany" method="post">
		<span>Select a company:</span> <select name="companyId">
			<%
				if (null != companies && !companies.isEmpty()) {
					for (Company com : companies) {
						out.println("<option value=" + com.getName() + "</option>");
					}
				}
			%>
		</select> 
		<br /> 
		<input type="submit" value="Search">
	</form>

	<%
		List<VideoGame> videogames = (List<VideoGame>) request.getAttribute("listAllVideogames");
		pageContext.setAttribute("videogames", videogames);
	%>
	<h4> List videogames: </h4>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>Recomended age</td>
				<td>LaunchDate</td>
				<td>ConsoleId</td>
			</tr>
		</thead>
		<tbody>
			<%
				if (null != videogames && !videogames.isEmpty()) {
					for (VideoGame videogame : videogames) {
						out.println("<tr>");
						out.println("<td>");
						out.println(videogame.getTitle());
						out.println("</td>");
						out.println("<td>");
						out.println(videogame.getRecommendedAge());
						out.println("</td>");
						out.println("<td>");
						out.println(videogame.getLaunchDate());
						out.println("</td>");
						out.println("<td>");
						out.println(videogame.getConsole());
						out.println("</td>");
						out.println("</tr>");
					}
				}
			%>
		</tbody>
	</table>
</body>
</html>