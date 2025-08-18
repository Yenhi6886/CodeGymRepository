<%--
  Created by IntelliJ IDEA.
  User: alych
  Date: 7/14/2025
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CustomerList</title>
</head>
<body>
<h2>CustomerList</h2>
<table border="1">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td>${c.id}</td>
            <td><a href="info.jsp?id=${c.id}">${c.name}</a></td>
            <td>${c.email}</td>
            <td>${c.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
