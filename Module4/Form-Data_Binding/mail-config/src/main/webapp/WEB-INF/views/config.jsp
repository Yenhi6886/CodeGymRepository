<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Settings</title>
</head>
<body>
<h2>Settings</h2>

<form:form modelAttribute="emailConfig" method="post">
    <label>Languages:</label>
    <form:select path="language" items="${languages}"/><br/>

    <label>Page Size:</label>
    Show <form:select path="pageSize" items="${pageSizes}"/> emails per page<br/>

    <label>Spams filter:</label>
    <form:checkbox path="spamsFilter"/> Enable spams filter<br/>

    <label>Signature:</label><br/>
    <form:textarea path="signature" rows="4" cols="40"/><br/>

    <input type="submit" value="Update"/>
</form:form>

</body>
</html>