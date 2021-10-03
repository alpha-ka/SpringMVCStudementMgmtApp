<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Spring MVC form tags copied from browser -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- CSS from Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<!-- Load CSS file -->
<link rel="stylesheet" type="text/css"
	href="/student-management/URLtoReachResourcesFolder/css/my-style-sheet.css">
<link rel="stylesheet" type="text/css"
	href="/student-management/URLtoReachResourcesFolder/css/add-student.css">

</head>
<body class="myFont">
	<!-- Create Form -->
	<div class="container" align="center">
		<div class="row">
			<div
				class="col-lg-6 col-md-6 col-sm-6 container justify-content-center">
				<h1 class="h1">Add Student</h1>
				<br>
				<div class="card-body">
					<form:form action="save-student" modelAttribute="student">
						<!-- Below form hidden  is used for update purpose because we should  value or else it will be empty -->
						<form:hidden path="id" />
						<div class="form-group">
							<label for="n">Name :</label>
							<form:input path="name" class="form-control" placeholder="Mr. x"
								id="n" />
						</div>

						<div class="form-group">
							<label for="m">Mobile :</label>
						
								<form:input path="mobile" class="form-control"
									placeholder="0123456789" id="m" />
							 
						</div>
						<div class="form-group">
							<label for="c"  >Country :</label>
							 
								<form:input path="country" class="form-control"
									placeholder="India" id="c" />
						 
						</div>


						<input class="btn btn-primary" role="button"
							data-bs-toggle="button" type="submit" value="Save">

					</form:form>
				</div>
			</div>
		</div>
		<img alt="students photos"
			src="/student-management/URLtoReachResourcesFolder/images/students.png">
	</div>
</body>
</html>