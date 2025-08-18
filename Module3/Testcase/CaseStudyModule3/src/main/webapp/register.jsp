<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng ký tài khoản</title>
</head>
<body>
<h2>Đăng ký tài khoản</h2>
<form method="post" action="user?action=register">
    Họ tên: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Mật khẩu: <input type="password" name="password" required><br><br>
    Địa chỉ: <input type="text" name="address"><br><br>
    Số điện thoại: <input type="text" name="phone"><br><br>
    Vai trò:
    <select name="roleId" required>
        <c:forEach var="role" items="${roles}">
            <option value="${role.roleId}">${role.roleName}</option>
        </c:forEach>
    </select>
    <br><br>
    <input type="submit" value="Đăng ký">
</form>
<p>Đã có tài khoản? <a href="user?action=showRegister">Đăng ký</a></p>
</body>
</html>