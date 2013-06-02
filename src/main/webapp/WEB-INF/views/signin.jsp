<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
      <h2>Connexion</h2>
      <form:form method="post" action="signin" commandName="geek">
        <div class="inputs">
          <form:label path="email" cssErrorClass="error">Ton email</form:label>
          <form:input path="email" cssErrorClass="error" required="required"/>
          <form:errors path="email" cssErrorClass="error"/>
          <form:label path="password" cssErrorClass="error">Ton mot de passe</form:label>
          <form:password path="password" cssErrorClass="error" required="required"/>
          <form:errors path="password" cssErrorClass="error"/>
        </div>
        <div class="buttons">
          <form:button type="submit">Créer mon compte !</form:button>
        </div>
      </form:form>
    </jsp:body>
</t:genericpage>