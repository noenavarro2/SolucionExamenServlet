<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VideoGame Register</title>
</head>
<body>
	<form action="videogame" method="post">
		<span>Title:</span> 
		<input type="text" name="title"/> <br/>
		<span>Recommended age:</span> 
		<input type="text" name="recommendedAge"/><br/>
		<span>Launch date:</span> 
		<input type="text" name="launchDate"/><br/>
		<input type="submit"/>
	</form>
</body>
</html>