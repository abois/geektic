<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!Doctype html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<c:url value='/static/css/style.css'></c:url>" rel="stylesheet" />
    <link href="<c:url value='/static/css/font-awesome.min.css'></c:url>" rel="stylesheet" />
    <title>Geektic</title>
  </head>
  <body>
    <header>
      <h1>GeeKTiC</h1>
      <nav>
        <ul>
          <li><a href="<c:url value='/'></c:url>"><i class="icon-home"></i><span>Accueil</span></a></li>
          <li><a href="<c:url value='/geeks'></c:url>"><i class="icon-group"></i><span>Geeks</span></a></li>
          <li><a href="<c:url value='/signin'></c:url>"><i class="icon-signin"></i><span>Connexion</span></a></li>
          <li><a href="<c:url value='/signup'></c:url>"><i class="icon-edit"></i><span>Inscription</span></a></li>
        </ul>
      </nav>
      <jsp:invoke fragment="header"/>
    </header>
    <section id="main-content">
      <jsp:doBody/>
    </section>
    <footer>
      <jsp:invoke fragment="footer"/>
    </footer>
  </body>
</html>