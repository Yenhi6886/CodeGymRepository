<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html><body>
<h2>TỜ KHAI Y TẾ</h2>

<form:form action="/declaration" modelAttribute="declaration" method="post">
  <div>Họ tên: <form:input path="fullName"/><form:errors path="fullName"/></div>
  <div>Năm sinh: <form:input path="yearOfBirth"/><form:errors path="yearOfBirth"/></div>
  <div>Giới tính:
    <form:radiobutton path="gender" value="Nam"/>Nam
    <form:radiobutton path="gender" value="Nữ"/>Nữ
  </div>
  <div>Quốc tịch: <form:input path="nationality"/></div>
  <div>CMND/Hộ chiếu: <form:input path="idNumber"/></div>
  <div>Phương tiện: <form:input path="vehicleType"/></div>
  <div>Số hiệu: <form:input path="vehicleId"/></div>
  <div>Số ghế: <form:input path="seatNumber"/></div>
  <div>Ngày đi: <form:input path="startDate" type="date"/></div>
  <div>Ngày kết thúc: <form:input path="endDate" type="date"/></div>
  <div>Tỉnh đã đến: <form:input path="visitedProvinces"/></div>
  <div>Địa chỉ liên lạc: <form:input path="address"/><form:errors path="address"/></div>
  <div>SĐT: <form:input path="phone"/></div>
  <div>Email: <form:input path="email"/></div>

  <div>Triệu chứng trong 14 ngày:
    <form:checkboxes path="symptoms" items="${symptomList}"/>
  </div>
  <div>Tiếp xúc gần:
    <form:checkboxes path="exposures" items="${exposureList}"/>
  </div>

  <input type="submit" value="Gửi tờ khai"/>
</form:form>
</body></html>
