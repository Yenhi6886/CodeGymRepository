<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Thông tin tờ khai đã lưu:</h2>
<p>Họ tên: ${declaration.fullName}</p>
<p>Năm sinh: ${declaration.yearOfBirth}</p>
<p>Giới tính: ${declaration.gender}</p>
<p>Triệu chứng: <c:forEach var="s" items="${declaration.symptoms}">${s}, </c:forEach></p>
<p>Tiếp xúc: <c:forEach var="e" items="${declaration.exposures}">${e}, </c:forEach></p>
