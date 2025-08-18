<%--
  Created by IntelliJ IDEA.
  User: alych
  Date: 7/14/2025
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Customer Info</title></head>
<body>
<h2>Customer Information</h2>
<p>Id: ${customer.id}</p>
<p>Name: ${customer.name}</p>
<p>Email: ${customer.email}</p>
<p>Address: ${customer.address}</p>

<a href="/customers">Back to list</a>
</body>
</html>

