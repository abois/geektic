<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<c:url value='/static/css/style.css'></c:url>" rel="stylesheet" />
    <title>Geektic</title>
  </head>
  <body>
    <header>
       <c:import url="header.jsp" />        
    </header>
	<section id="wrapper">
	  <h2>Welcome Geeks !</h2>
      <ul>
        <c:forEach var="geek" begin="0" items="${geeks}">
        <li><a href="<c:url value='/geek'><c:param name='id' value='${geek.id}'/></c:url>">${geek.prenom} ${geek.nom}</a></li>
        </c:forEach>
      </ul>
	</section>
  </body>
</html>