<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Chuyển đổi USD sang VNĐ</h2>
<form method="post" action="/convert">
    Tỷ giá: <input type="number" name="rate" step="0.01" required><br><br>
    USD: <input type="number" name="usd" step="0.01" required><br><br>
    <button type="submit">Convert</button>
</form>

<c:if test="${not empty vnd}">
    <h3>Kết quả: ${usd} USD x ${rate} = <strong>${vnd} VNĐ</strong></h3>
</c:if>
</body>
</html>
