<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.05.2021
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="login" method="post">
    <div>
        <label>Login</label>
        <input type="text" name = "login"/>
    </div>
    <div>
        <label>Password</label>
        <input type="text" name = "password" />
    </div>
    <div>
        <input type="submit" value="Sign in"/>
    </div>
</form>

<a href="index.jsp">Back</a>

</body>
</html>
