<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<t:genericpage>
    <jsp:body>
      <h2>Geeks !</h2>
      <div id="list-geeks">
        <c:forEach var="geek" begin="0" items="${geeks}">
        <div>
          <a href="<c:url value='/geeks/${geek.id}'></c:url>" class="${geek.gender?'female':'male'}">${geek.firstname} ${geek.lastname}</a>
          <figure>
            <img src="${geek.avatar?geek.avatar:'/geektic/static/images/unknown.gif'}">
          </figure>
          <span class="list-title">Centres d'intérêt</span>
          <ul>
            <c:forEach var="interest" begin="0" items="${geek.interests}">
            <li>${interest.name}</li>
            </c:forEach>
          </ul>
        </div>
        </c:forEach>
      </div>
    </jsp:body>
</t:genericpage>
