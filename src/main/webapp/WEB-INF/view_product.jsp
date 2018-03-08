<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<h1><c:out value="${product.name}"/></h1>

<h2>Categories:</h2>
<ul>
    <c:forEach items="${product.categories}" var="category">
        <li><c:out value="${category.name}"/></li>
    </c:forEach>
</ul>

<form:form method="POST" action="/products/${product.id}/add_category/" modelAttribute="product">
    <form:errors path="categories"/>
    Add Category:
    <form:select path="categories">
        <c:forEach items="${categories}" var="c">
            <c:set var="addedBool" value="false"/>
            <c:forEach items="${product.categories}" var="pc">
                <c:if test="${c == pc}">
                    <c:set var="addedBool" value="true"/>
                </c:if>
            </c:forEach>

            <c:if test="${!addedBool}">
                <option value="${c.id}">${c.name}</option>
            </c:if>
        </c:forEach>
    </form:select>

    <input type="submit" value="Add">
</form:form>

</html>