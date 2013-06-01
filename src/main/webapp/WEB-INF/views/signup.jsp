<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
      <h2>Inscription à GeeKTiC</h2>
      <form:form method="post" action="signup" commandName="geek">
        <form:label path="firstname" cssClass="error">Ton prénom</form:label>
        <form:input path="firstname" cssClass="error"/>
        <form:errors path="firstname" cssClass="error"/>
        <form:label path="lastname" cssClass="error">Ton nom</form:label>
        <form:input path="lastname" cssClass="error"/>
        <form:errors path="lastname" cssClass="error"/>
        <form:label path="email" cssClass="error">Ton email</form:label>
        <form:input path="email" cssClass="error"/>
        <form:errors path="email" cssClass="error"/>
        <form:label path="gender" cssClass="error">Ton sexe</form:label>
        <form:checkbox path="gender" cssClass="error"/>
        <form:errors path="gender" cssClass="error"/>
        <form:label path="interests" cssClass="error">Tes centres d'intérêt</form:label>
        <form:select path="interests">
        <form:options items="${interests}" itemValue="id" itemLabel="name" />
        </form:select>
        <form:errors path="interests" cssClass="error"/>
        <form:button type="submit">Créer mon compte !</form:button>
      </form:form>
    </jsp:body>
</t:genericpage>