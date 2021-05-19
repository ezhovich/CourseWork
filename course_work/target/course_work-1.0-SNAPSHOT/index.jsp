<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Dictionary" %>
</h1>
<br/>

<style>
    div {
        margin-left: 1100px;
    }
    label {
        display: inline-block;
        width: 150px;
        text-align: right;
    }
</style>


<c:if test="${valid == 1}">
    <form action="signout" method="post">
        <div>
            <input type="submit" value="Sign out"/>
        </div>
    </form>
</c:if>


<a href="viewLanguages">View languages</a></br>
<a href="viewTranslations">Translate word</a></br>
<a href="login.jsp">Login as admin </a>






</body>
</html>