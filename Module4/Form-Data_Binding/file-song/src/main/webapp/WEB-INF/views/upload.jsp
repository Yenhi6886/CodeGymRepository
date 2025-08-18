<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>Upload Song</title></head>
<body>
<h2>Upload Bài Hát</h2>
<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>

<form action="/upload" method="post" enctype="multipart/form-data">
  Tên bài hát: <input type="text" name="name"><br/>
  Nghệ sĩ: <input type="text" name="artist"><br/>
  Thể loại: <input type="text" name="genre"><br/>
  File bài hát: <input type="file" name="file"><br/>
  <input type="submit" value="Upload">
</form>

</body>
</html>
