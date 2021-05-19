<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.04.2021
  Time: 23:05
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


<ul>
    <c:forEach var="l" items="${languages}">
        <li>
            <a href="viewWords?languageId=${l.getId()}"> <c:out value="${l.getName()}" /></a>
        </li>
    </c:forEach>
</ul>


</body>
</html>
