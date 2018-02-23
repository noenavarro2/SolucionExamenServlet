<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ page import="java.io.*,java.util.*,es.salesianos.model.Console"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Console List</title>
</head>
<body>
	<%
		List<Console> listConsole = (List<Console>) request.getAttribute("listAllConsole");
		pageContext.setAttribute("listConsole", listConsole);
	%>

	<form action="dataConsoles" method="post">

		<table border="1">
			<thead>
				<tr>
					<td>Name</td>
					<td>Company</td>
				</tr>
			</thead>
			<c:forEach items="${consoles}" var="consoles">
				<tr>
					<td><c:out value="${consoles.name}" /></td>
					<td><c:out value="${consoles.company}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Submit">
	</form>

</body>
</html>
