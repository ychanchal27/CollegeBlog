<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>College Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<form action="CollegeRegistrationServlet" method="POST">
	<div class="form-group">
    <label for="exampleInputEmail1">College Name</label>
    <input name="collegeName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter college name">
    <small id="college name Help" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">faculity Name</label>
    <input name="faculityName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter faculity name">
    <small id="facuilty name Help" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
	
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input  name="emailAddress"type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder=" Enter Password">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>