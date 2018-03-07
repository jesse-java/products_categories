<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<form:form method="POST" action="/categories/create" modelAttribute="category">
    <fieldset>
        <legend>New Category</legend>
        <form:label path="name">Name:
            <form:errors path="name"/>
            <form:input path="name"/>
        </form:label>

        <input type="submit" value="Submit">
    </fieldset>
</form:form>
</body>
</html>