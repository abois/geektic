<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Geek</title>
  </head>
  <body>
    <header>
      <c:import url="header.jsp"></c:import>
    </header>
    <section id="wrapper">
      ${geek.id} ${geek.prenom} ${geek.nom}
    </section>
  </body>
</html>