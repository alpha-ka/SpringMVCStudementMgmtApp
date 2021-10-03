<!-- To show property value from Model object please mention this isELIgnored to false-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
        <!-- JSTL Core Url Tag for URL pattern  and also C is prefix-->
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<h1 align="center">Student Management</h1>
<hr>
<div align="center">
<table border="1">
<tr>
<thead>
<td>S No.</td>
<td>Name</td>
<td>Mobile</td>
<td>Country</td>
</thead>
</tr>

<c:forEach var="student" items="${students}">
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.mobile}</td>
<td>${student.country}</td>
</tr>

</c:forEach>

</table>
</div>
</body>
</html>