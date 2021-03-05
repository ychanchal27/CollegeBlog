<%@ page import="com.ips.collegeblog.entity.College"%>
<%@ page import="com.ips.collegeblog.dao.CollegeDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.ips.collegeblog.helper.ConnectionProvider"%>
<%@ page import="com.ips.collegeblog.dao.PostblogDao"%>
<%@page import="com.ips.collegeblog.entity.PostBlog"%>



<%
College college = (College) session.getAttribute("currentUser");
if (college == null) {
	response.sendRedirect("login_as_college.jsp");
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>load post page</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<%
				PostblogDao d = new PostblogDao(ConnectionProvider.getConn());
				//d.getAllPost();

				ArrayList<PostBlog> list = d.getAllPost();
				for (PostBlog pb : list) {
				%>
				<div class="card mt-3">
					<div class="card title bg-light"> <%=pb.getTitle()%></div>
					<div class="card-body">
						<h3><%=pb.getTopic()%></h3>
						<p><%=pb.getPostBlog()%></p>
					</div>
					<div class="card-footer">
						<button class="btn btn-primary">see more...</button>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>