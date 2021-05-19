<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.05.2021
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Languages</title>
</head>
<body>

<h1>Languages</h1>


<form action="AddLanguage" method="get">
    Language: <input type="text" name = "language" value="">
    <input type="submit" value="Add language"/>
</form>

<c:if test="${error != null}">
    <p style="color:red"><c:out value="${error}" /></p>
</c:if>

<ul>
    <c:forEach var="u" items="${languages}">
        <li>
            <form action="DeleteLanguage" method="get">
                <a href="EditWords?languageId=${u.getId()}"><c:out value="${u.getName()}" /></a>
                <input type="hidden" name="lanId" value="${u.getId()}">
                <input type="submit" value="remove">
            </form>
        </li>

    </c:forEach>
</ul>

<a href="signout">log out</a>

</body>
</html>
