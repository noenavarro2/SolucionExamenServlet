<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.VideoGame"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List recommended age</title>
</head>
<body>

	<h2>VIDEOGAMES</h2>

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
				<td>Release date</td>
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
						out.println("</tr>");
					}
				}
			%>
		</tbody>
	</table>
</body>
</html>