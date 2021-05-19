
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Words in <c:out value="${name}" /> language</h1>




<form action="AddWord" method="get">
    Add word: <input type="text" name = "word" value="">
    <input type="hidden" name="languageId" value="${param.languageId}">
    <input type="submit" value="Add word"/>
</form>


<ul>
    <c:forEach var="w" items="${words}">
        <li>
            <form action="DeleteWord" method="get">
                <a> <c:out value="${w.getName()}" /></a>
                <input type="hidden" name="wordId" value="${w.getId()}">
                <input type="hidden" name="languageId" value="${param.languageId}">
                <input type="submit" value="remove word"/>
            </form>

            <form action="AddTranslation" method="get">
                Add translation: <input type="text" name = "translation" value="">
                From language
                <select name="translationLanguage">
                    <c:forEach var="l" items="${languages}">
                        <option value=${l.getId()}><c:out value="${l.getName()}" /></option>
                    </c:forEach>
                </select>
                <input type="hidden" name="wordId" value="${w.getId()}">
                <input type="hidden" name="languageId" value="${param.languageId}">
                <input type="submit" value="Add translation"/>
            </form>

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
