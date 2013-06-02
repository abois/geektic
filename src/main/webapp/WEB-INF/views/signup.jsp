<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
      <h2>Inscription</h2>
      <form:form method="post" action="signup" commandName="geek">
        <div class="inputs">
          <form:label path="firstname" cssErrorClass="error">Ton prénom</form:label>
          <form:input path="firstname" cssErrorClass="error" required="required"/>
          <form:errors path="firstname" cssErrorClass="error"/>
          <form:label path="lastname" cssErrorClass="error">Ton nom</form:label>
          <form:input path="lastname" cssErrorClass="error" required="required"/>
          <form:errors path="lastname" cssErrorClass="error"/>
          <form:label path="password" cssErrorClass="error">Ton mot de passe</form:label>
          <form:password path="password" cssErrorClass="error" required="required"/>
          <form:errors path="password" cssErrorClass="error"/>
          <form:label path="email" cssErrorClass="error">Ton email</form:label>
          <form:input path="email" cssErrorClass="error" required="required" type="email"/>
          <form:errors path="email" cssErrorClass="error"/>
          <form:label path="gender" cssErrorClass="error">Ton sexe</form:label>
          <form:checkbox path="gender" cssErrorClass="error"/>
          <form:errors path="gender" cssErrorClass="error"/>
          <form:label path="interests" cssErrorClass="error">Tes centres d'intérêt</form:label>
          <form:select path="interests">
          <form:options items="${interests}" itemValue="id" itemLabel="name" />
          </form:select>
        </div>
        <form:errors path="interests" cssErrorClass="error"/>
        <div class="buttons">
          <form:button type="submit">Créer mon compte !</form:button>
        </div>
      </form:form>
    </jsp:body>
</t:genericpage>