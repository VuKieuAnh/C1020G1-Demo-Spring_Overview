<%--
  Created by IntelliJ IDEA.
  User: vuanh
  Date: 3/1/21
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách HV</h1>
<table>
    <tr>
        <td>ten</td>
        <td>dc</td>
    </tr>
    <c:forEach items="${list}" var="st">
        <tr>
            <td>${st.name}</td>
            <td>${st.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
