<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.ips.collegeblog.entity.College"%>
<!DOCTYPE html>
<html>
<head>
<!--css-->
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>College Profile</title>
</head>
<body>
<jsp:include page="resources.jsp" />
	<%
	College college = (College) session.getAttribute("currentUser");
	if (college == null) {
		response.sendRedirect("login_as_college.jsp");
	}
	%>

	<!--navbar-->

	<nav class="navbar navbar-expand-lg  navbar-dark bg-primary">
		<a class="navbar-brand" href="#">College Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item"><a class="nav-link" href="post_page.jsp">
						<span class="fa fa-code "></span> Post Blog
				</a></li>



			</ul>

			<ul class="navbar-nav mr-right">
				<li class="nav-item"><a class="nav-link" href="#!"
					data-toggle="modal" data-target="#profile-modal"> <span
						class="fa fa-user-circle "></span> <%=college.getFacultyName()%>
				</a></li>

				<li class="nav-item"><a class="nav-link"
					href="CollegeLogoutServlet"><span class="fa fa-power-off"></span>
						Logout
				</a></li>
			</ul>
		</div>
	</nav>



	<!--end of navbar-->

<!-- 		Main content Devision starts -->
	<div id="content"></div>
<!-- 		Main content Devision ends -->

	<!--profile modal-->



	<!-- Modal -->
	<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header primary-background text-white text-center">
					<h5 class="modal-title" id="exampleModalLabel">College Blog</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">

						<br>
						<h5 class="modal-title mt-3" id="exampleModalLabel">
							<%=college.getFacultyName()%>
						</h5>
						<!--//details-->

						<div id="profile-details">
							<table class="table">

								<tbody>
									<tr>
										<th scope="row">ID :</th>
										<td><%=college.getId()%></td>


									</tr>
									<tr>
										<th scope="row">Email :</th>
										<td><%=college.getEmailAddress()%></td>

									</tr>
									<tr>
										<th scope="row">College :</th>
										<td><%=college.getCollegeName()%></td>

									</tr>

								</tbody>
							</table>
						</div>

						<!--profile edit-->

						<div id="profile-edit" style="display: none;">
							<h3 class="mt-2">Please Edit Carefully</h3>
							<form action="CollegeFacultyUpdateServlet" method="post">
								<table class="table">
									<tr>
										<td>ID :</td>
										<td><%=college.getId()%></td>
									</tr>
									<tr>
										<td>Email :</td>
										<td><input type="email" class="form-control"
											name="email" value="<%=college.getEmailAddress()%>">
										</td>
									</tr>
									<tr>
										<td>Name :</td>
										<td><input type="text" class="form-control" name="name"
											value="<%=college.getFacultyName()%>"></td>
									</tr>
									<tr>
										<td>Password :</td>
										<td><input type="password" class="form-control"
											name="pass" value="<%=college.getPassword()%>">
										</td>
									</tr>
									<tr>
										<td>College :</td>
										<td><%=college.getCollegeName().toUpperCase()%></td>
									</tr>
									<%-- <tr>
                                            <td>About  :</td>
                                            <td>
                                                <textarea rows="3" class="form-control" name="f_about" ><%= college.getFabout() %> </textarea>
                                               

                                            </td>
                                        </tr> --%>
									<!-- <tr>
										<td>New Profile:</td>
										<td><input type="file" name="image" class="form-control">
										</td>
									</tr> -->

								</table>

								<div class="container">
									<button type="submit" class="btn btn-outline-primary">Save</button>
								</div>

							</form>

						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="edit-profile-button" type="button"
						class="btn btn-primary">EDIT</button>
				</div>
			</div>
		</div>
	</div>
	<!--end of profile modal-->




<script>
	$(document).ready(function(){
		$("#content").load("loadcontentforcollege.jsp");
	})
</script>



	<script>
		$(document).ready(function() {
			let editStatus = false;
			$('#edit-profile-button').click(function() {
				if (editStatus == false) {
					$("#profile-details").hide()
					$("#profile-edit").show();
					editStatus = true;
					$(this).text("Back")
				} else {
					$("#profile-details").show()
					$("#profile-edit").hide();
					editStatus = false;
					$(this).text("Edit")
				}
			})
		});
	</script>
	
	


	

</body>
</html>