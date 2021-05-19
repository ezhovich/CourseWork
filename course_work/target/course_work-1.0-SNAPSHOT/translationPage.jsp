<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.04.2021
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Translate</title>
</head>
<br>

<body>
<h1>Translate</h1>




<form action="translateWord" method="get">
    Translate word <input type="text" name = "word" value="">
    <a>From</a>
    <select name="fromLanguage">
        <c:forEach var="l" items="${languages}">
            <option value=${l.getId()}><c:out value="${l.getName()}" /></option>
        </c:forEach>
    </select>

    <a>To</a>
    <select name="toLanguage">
        <c:forEach var="l" items="${languages}">
            <option value=${l.getId()}><c:out value="${l.getName()}" /></option>
        </c:forEach>
    </select>

    <input type="submit" value="translate"/>

</form>

</br>


<c:if test="${translation != null}">
    <p style="color:red"><c:out value="${translation}" /></p>
</c:if>

</body>
</html>
