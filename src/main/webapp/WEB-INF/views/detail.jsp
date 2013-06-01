<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<t:genericpage>
    <jsp:body>
      <h2>${geek.firstname} ${geek.lastname}</h2>
      <div>
        ${geek.firstname} ${geek.lastname} ${geek.gender == true ? 'Femme' : 'Homme'} ${geek.email}
        <h3>Centres d'intérêt</h3>
        <ul>
          <c:forEach var="interest" begin="0" items="${geek.interests}">
          <li>${interest.name}</li>
          </c:forEach>
        </ul>
      </div>     
    </jsp:body>
</t:genericpage>