<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Result</title>
</head>
<body>
<h2>Configuration Updated Successfully!</h2>
<div style="border: 1px solid #ccc; padding: 15px; margin: 10px 0;">
    <h3>Your Email Configuration:</h3>
    <p><b>Language:</b> <c:out value="${emailConfig.language}"/></p>
    <p><b>Page Size:</b> <c:out value="${emailConfig.pageSize}"/> emails per page</p>
    <p><b>Spams Filter:</b>
        <c:choose>
            <c:when test="${emailConfig.spamsFilter}">
                Enabled
            </c:when>
            <c:otherwise>
                Disabled
            </c:otherwise>
        </c:choose>
    </p>
    <p><b>Signature:</b><br/>
       <pre><c:out value="${emailConfig.signature}"/></pre>
    </p>
</div>
<a href="${pageContext.request.contextPath}/config" style="text-decoration: none; background: #007bff; color: white; padding: 8px 16px; border-radius: 4px;">Back to Settings</a>
</body>
</html>