<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<!Doctype html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<c:url value='/static/css/style.css'></c:url>" rel="stylesheet" />
    <title>Geektic</title>
  </head>
  <body>
    <header>
      <h1>GeeKTiC</h1>
      <nav>
        <ul>
          <li><a href="<c:url value='/'></c:url>">Accueil</a></li>
          <li><a href="<c:url value='/geeks'></c:url>">Geeks</a></li>
          <li><a href="<c:url value='/signup'></c:url>">Inscription</a></li>
        </ul>
      </nav>
      <jsp:invoke fragment="header"/>
    </header>
    <div id="main-content">
      <jsp:doBody/>
    </div>
    <footer>
      <jsp:invoke fragment="footer"/>
    </footer>
  </body>
</html>