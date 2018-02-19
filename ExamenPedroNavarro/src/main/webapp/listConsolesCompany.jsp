<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page
	import="java.io.*,java.util.*,es.salesianos.model.Console,es.salesianos.model.Company"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Consoles from Company</title>
</head>
<body>

	<h2>Consoles from Company</h2>

	<form action="listDropDownCompaniesConsole" method="post">
		<input type="submit" value="See companies">
	</form>
	<br/>
	<%
		List<Company> companies = (List<Company>) request.getAttribute("listAllCompanies");
		pageContext.setAttribute("companies", companies);
	%>


	<form action="listConsolesCompany" method="post">
		<span>Select a company:</span> <select name="companyId">
			<%
				if (null != companies && !companies.isEmpty()) {
					for (Company com : companies) {
						out.println("<option value=" + com.getName() +"</option>");
					}
				}
			%>
		</select> 
		<br /> 
		<input type="submit" value="Search">
	</form>

	<%
		List<Console> consoles = (List<Console>) request.getAttribute("listAllConsoles");
		pageContext.setAttribute("consoles", consoles);
	%>
	<h4> List consoles: </h4>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>CompanyId</td>
			</tr>
		</thead>
		<tbody>

			<%
				if (null != consoles && !consoles.isEmpty()) {
					for (Console con : consoles) {
						out.println("<tr>");
						out.println("<td>");
						out.println(con.getName());
						out.println("</td>");
						out.println("<td>");
						out.println(con.getCompany());
						out.println("</td>");
						out.println("</tr>");
					}
				}
			%>

		</tbody>
	</table>
</body>
</html>