<%--
  Created by IntelliJ IDEA.
  User: vuanh
  Date: 3/2/21
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sửa Student</h1>
<form method="post">
    <input name="name" value="${student.name}">
    <input name="address" value="${student.address}">
    <button type="submit">Edit</button>
</form>
</body>
</html>
