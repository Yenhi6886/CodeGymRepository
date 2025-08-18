<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>JSTL Test</title></head>
<body>

<%-- Gán biến --%>
<c:set var="name" value="Bạn Chơi Với JSTL!" />

<%-- Hiển thị biến --%>
<h2>Chào: <c:out value="${name}" /></h2>

</body>
</html>
