package com.ips.collegeblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ips.collegeblog.dao.CollegeDao;
import com.ips.collegeblog.entity.College;
import com.ips.collegeblog.helper.ConnectionProvider;

/**
 * Servlet implementation class CollegeRegistrationServlet
 */
@WebServlet("/CollegeRegistrationServlet")
public class CollegeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeRegistrationServlet() {
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
		response.setContentType("text/html");
		try(PrintWriter out= response.getWriter()) {
			String collegeName =request.getParameter("collegeName");
			String facultyName=request.getParameter("faculityName");
			String emailAddress=request.getParameter("emailAddress");
			String password=request.getParameter("password");
			
			College college= new College(collegeName, facultyName, emailAddress, password);
			
			// creating collegeDao object...
			CollegeDao dao= new CollegeDao(ConnectionProvider.getConn());
			if(dao.saveCollege(college)) {
				out.print("done");
			}else {
				out.print("something went wrong !");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
