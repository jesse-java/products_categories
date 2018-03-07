<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<form:form method="POST" action="/products/create" modelAttribute="product">
    <fieldset>
        <legend>New Product</legend>
        <form:label path="name">Name:
            <form:errors path="name"/>
            <form:input path="name"/>
        </form:label>

        <form:label path="description">Description:
            <form:errors path="description"/>
            <form:input path="description"/>
        </form:label>

        <form:label path="price">Price:
            <form:errors path="price"/>
            <form:input path="price"/>
        </form:label>

        <input type="submit" value="Submit">
    </fieldset>
</form:form>
</body>
</html>