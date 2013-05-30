<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="" rel="stylesheet"/>
    <title>Geektic</title>
  </head>
  <body>
    <header>
       <c:import url="header.jsp" />        
    </header>
    <section id="wrapper">
      <ul>
        <c:forEach var="geek" begin="0" items="${geeks}">
        <li><a href="<c:url value='/geek'><c:param name='id' value='${geek.id}'/></c:url>">${geek.prenom} ${geek.nom}</a></li>
        </c:forEach>
      </ul>
    </section>
  </body> 
</html>