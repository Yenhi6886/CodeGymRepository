<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
<h1>Selected Condiments:</h1>
<ul>
    <c:forEach var="item" items="${condimentList}">
        <li>${item}</li>
    </c:forEach>
</ul>
<a href="/">Back</a>
</body>
</html>
