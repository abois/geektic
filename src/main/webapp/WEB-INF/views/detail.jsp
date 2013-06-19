<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<t:genericpage>
    <jsp:body>
      <h2 class="${geek.gender ? 'female' : 'male'}">${geek.firstname} ${geek.lastname}</h2>
      <div id="detail-geek">
        <figure>
           <img src="${geek.avatar?'test':'/geektic/static/images/unknown.gif'}">
        </figure>
        <h3 class="${geek.gender ? 'female' : 'male'}">Centres d'intérêt</h3>
        <ul>
          <c:forEach var="interest" begin="0" items="${geek.interests}">
          <li>${interest.name}</li>
          </c:forEach>
        </ul>
        <h3 class="${geek.gender ? 'female' : 'male'}">Description</h3>
        <p>
          ${not empty geek.description ? geek.description : "N' a pas souhaité se décrire..."}
        </p>
        <h3 class="${geek.gender ? 'female' : 'male'}">Contact</h3>
        <ul>
          <li>Email : ${geek.email}</li>
        </ul>
        <h3 class="${geek.gender ? 'female' : 'male'}">Nombre de visites</h3>
        <p>${geek.visitCount}</p>
      </div>     
    </jsp:body>
</t:genericpage>