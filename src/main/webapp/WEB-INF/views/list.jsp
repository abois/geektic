<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<t:genericpage>
    <jsp:body>
      <h2>Geeks !</h2>
      <ul>
        <c:forEach var="geek" begin="0" items="${geeks}">
        <li>
          <a href="<c:url value='/geek/${geek.id}'></c:url>">${geek.firstname} ${geek.lastname}</a>
          <span class="gender">${geek.gender == true ? 'Femme' : 'Homme'}</span>
        </li>
        </c:forEach>
      </ul>
    </jsp:body>
</t:genericpage>
