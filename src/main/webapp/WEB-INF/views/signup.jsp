<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:genericpage>
    <jsp:body>
      <h2>Inscription à GeeKTiC</h2>
      <form:form method="post">
       
          <table>
          <tr>
              <td><form:label path="">First Name</form:label></td>
              <td><form:input path="prenom" /></td>
          </tr>
          <tr>
              <td><form:label path="nom">Last Name</form:label></td>
              <td><form:input path="nom" /></td>
          </tr>
          <tr>
              <td><form:label path="email">Email</form:label></td>
              <td><form:input path="email" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Add geek"/>
              </td>
          </tr>
      </table> 
      </form:form>
    </jsp:body>
</t:genericpage>