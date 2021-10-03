<!-- To show property value from Model object please mention this isELIgnored to false-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!-- JSTL Core Url Tag for URL pattern  and also C is prefix-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
<!-- CSS from Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<!-- Load CSS file -->
<link rel="stylesheet" type="text/css"
	href="/student-management/URLtoReachCSSFolder/my-style-sheet.css">
<link rel="stylesheet" type="text/css"
	href="/student-management/URLtoReachCSSFolder/add-student.css">

</head>
<body class="myFont">

	<h1 class="h1" align="center">Student Management</h1>
	<br>
<div class="container" align="center">	
		<form action="/student-management/showAddStudentPage">
			<input class="btn btn-primary" role="button" data-bs-toggle="button"
				type="submit" value="Add" />
		</form>
	</div>
	<br>
	<div class="container"  align="center">

		<table class="table table-striped" border="1">
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
					<td><a
						href="/student-management/updateStudent?id=${student.id}"
						class="btn btn-secondary btn-sm">Update</a></td>
					<td><a
						href="/student-management/deleteStudent?id=${student.id}"
						class="btn btn-danger btn-sm"
						onclick="if(!(confirm('Are you sure you want to delete ${student.name} record?'))) return false">Delete</a></td>
				</tr>

			</c:forEach>

		</table>

		<img alt="students photos"
			src="/student-management/URLtoReachResourcesFolder/images/students.png">

	</div>
</body>
</html>