<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<form action="StudentRegistrationservlet" method="Post">
		<div class="form-group">
			<label for="exampleInputEmail1">Student Name</label> <input
				name="studentName" type="text" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				placeholder="Enter Student Name"> <small
				id="Student name Help" class="form-text text-muted">We'll
				never share your email with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Student Email</label> <input
				name="studentEmail" type="email" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				placeholder="Enter  student email"> <small
				id=" student emailHelp" class="form-text text-muted">We'll
				never share your email with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Contact Number</label> <input
				name="contactNumber" type="text" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp"
				placeholder="Enter Contact Number"> <small
				id="Concat Number Help" class="form-text text-muted">We'll
				never share your email with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				name="password" type="password" class="form-control"
				id="exampleInputPassword1" placeholder=" Enter Password">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>


	</form>

</body>
</html>