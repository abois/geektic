<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:genericpage>
    <jsp:body>
	  <h2>Welcome Geeks !</h2>
      <div id="home-geeks">
        <div class="search-result">
        	<h3>Je recherche ...</h3>
	        <form method="get" action="<c:url value='/geeks/search'></c:url>" id="search-geeks">
	          <h4>Intérets</h4>
	          <ul>
	          <c:forEach var="interest" items="${interests}">
	            <li id="${interest.id}">${interest.name}</li>
	          </c:forEach>
	          </ul>
	          <select multiple class="hidden" name="interests">
	            <c:forEach var="interest" items="${interests}">
	            <option value="${interest.id}">${interest.name}</option>
	          </c:forEach>
	          </select>
	          <h4>Sexe</h4>
	          <input type="checkbox" value="0" id="male-checkbox" name="gender"><label for="male-checkbox">Homme</label><i class="icon-male male"></i>
	          <input type="checkbox" value="1" id="female-checkbox" name="gender"><label for="female-checkbox">Femme</label><i class="icon-female female"></i>
	          <div class="buttons">
	            <button type="submit">Rechercher !</button>
	          </div>
	        </form>
	        <h3>J'ai de la chance ...</h3>
	        <form method="post" action="/api/geeks/feelLucky" id="feel-lucky">
	          <button type="submit">J'ai de la chance !</button>
	        </form>
	    </div>
      </div>
    </jsp:body>
</t:genericpage>