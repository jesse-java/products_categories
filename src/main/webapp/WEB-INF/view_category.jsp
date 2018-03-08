<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<h1><c:out value="${category.name}"/></h1>

<ul>
    <c:forEach items="${category.products}" var="product">
        <li><c:out value="${product.name}"/></li>
    </c:forEach>
</ul>


<form action="/categories/${category.id}/add_product" method="POST">
    Add Product:
    <select name="product" id="">
        <c:forEach items="${products}" var="p">
            <c:set var="addedBool" value="false"/>
            <c:forEach items="${category.products}" var="cp">
                <c:if test="${p == cp}">
                    <c:set var="addedBool" value="true"/>
                </c:if>
            </c:forEach>

            <c:if test="${!addedBool}">
                <option value="${p.id}">${p.name}</option>
            </c:if>
        </c:forEach>

    </select>

    <input type="submit" value="Add">
</form>
</body>
</html>