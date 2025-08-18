<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Từ điển Anh – Việt</title>
</head>
<body>
<h2>Tra cứu từ điển Anh – Việt</h2>

<form action="/search" method="post">
    Nhập từ tiếng Anh:
    <input type="text" name="word" required/>
    <button type="submit">Tra cứu</button>
</form>

<c:if test="${not empty word}">
    <p><strong>${word}</strong> nghĩa là: <em>${result}</em></p>
</c:if>

</body>
</html>
