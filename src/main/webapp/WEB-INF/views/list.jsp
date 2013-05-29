<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/css/bootstrap.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
  <table>
	<tr>
	    <th>ID</th>
	    <th>Titre</th>
	    <th>Artiste</th>
	</tr>
	<c:forEach var="spectacle" begin="0" items="${spectacles}">
	<tr>
	    <td>${spectacle.id}</td> 
	    <td>${spectacle.titre}</td> 
	    <td>${spectacle.artiste}</td> 
	</tr> 
	
	</c:forEach>
  </table>
</body> 
</html>