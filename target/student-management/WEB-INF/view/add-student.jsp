<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Spring MVC form tags copied from browser -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Create Form -->
<div align="center" border="1">
<h2>Add Student</h2>
<br>
<form:form action="save-student" modelAttribute="students" method="Get">
<label for="n">Name :</label>
<form:input path="name" id="n"/>
<br>
<label for="m">Mobile :</label>
<form:input path="mobile" id="m"/>
<br>
<label for="c">Country :</label>
<form:input path="country" id="c"/>
<br>
<input type="submit" value="Submit">
</form:form>
</div>
</body>
</html>