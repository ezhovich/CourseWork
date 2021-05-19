<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.04.2021
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Words in <c:out value="${name}" /> language</h1>


<ul>
    <c:forEach var="w" items="${words}">
        <li>
            <a> <c:out value="${w.getName()}" /></a><br/>
            <c:forEach var="t" items="${w.getTranslationLanguages()}">
                <a>in <c:out value="${w.getLanguage(t)}" /> language:</a>
                <a> <c:out value="${w.getTranslationFromLanguage(t).getName()}" /></a>
                <br/>
            </c:forEach>
        </li>
    </c:forEach>
</ul>

</body>
</html>
