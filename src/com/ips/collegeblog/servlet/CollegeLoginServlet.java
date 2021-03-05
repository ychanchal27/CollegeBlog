package com.ips.collegeblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ips.collegeblog.dao.CollegeDao;
import com.ips.collegeblog.dao.PostblogDao;
import com.ips.collegeblog.entity.College;
import com.ips.collegeblog.entity.PostBlog;
import com.ips.collegeblog.helper.ConnectionProvider;

/**
 * Servlet implementation class CollegeLoginServlet
 */
@WebServlet("/CollegeLoginServlet")
public class CollegeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter out=response.getWriter())
		{
			String emailAddress=request.getParameter("emailAddress");
			String  password=request.getParameter("password");
			
			CollegeDao dao= new CollegeDao(ConnectionProvider.getConn());
			
			College college= dao.getUserByEmailAndPassword(emailAddress, password);
			if(college==null) {
				out.print("invalid username or password !");
				response.sendRedirect("login_as_college.jsp");
			}else {
				System.out.println("logged in user detail:"+ college);
				HttpSession s= request.getSession();
				s.setAttribute("currentUser", college);
				out.print("login success !");
				//PostblogDao daoo=new PostblogDao(ConnectionProvider.getConn());
			//	daoo.getAllPost();
				response.sendRedirect("college_profile.jsp");
			}
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
