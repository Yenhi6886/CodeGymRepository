<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Danh sách bài hát</title></head>
<body>
<h2>Danh sách bài hát đã upload</h2>
<table border="1">
  <tr>
    <th>Tên</th>
    <th>Nghệ sĩ</th>
    <th>Thể loại</th>
    <th>File</th>
  </tr>
  <c:forEach items="${songs}" var="s">
    <tr>
      <td>${s.name}</td>
      <td>${s.artist}</td>
      <td>${s.genre}</td>
      <td><audio controls src="${s.filePath}"></audio></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
