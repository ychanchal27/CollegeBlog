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
import com.ips.collegeblog.entity.College;
import com.ips.collegeblog.helper.ConnectionProvider;

/**
 * Servlet implementation class CollegeFacultyUpdateServlet
 */
@WebServlet("/CollegeFacultyUpdateServlet")
public class CollegeFacultyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeFacultyUpdateServlet() {
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
		try(PrintWriter out= response.getWriter()) {
			String facultyName=request.getParameter("name");
			String emailAddress=request.getParameter("email");
			String password=request.getParameter("pass");
			
			HttpSession s= request.getSession();
			College c= (College) s.getAttribute("currentUser");
			String collegeName= c.getCollegeName();
			Integer id= c.getId();
			System.out.println("college update servlet:"+id+""+collegeName+""+facultyName+""+emailAddress+""+password);
			
			
			College college= new College(collegeName, facultyName, emailAddress, password);
			
			// creating collegeDao object...
			CollegeDao dao= new CollegeDao(ConnectionProvider.getConn());
			if(dao.updateFaculty(college,id)) {
				out.print("done");
			}else {
				out.print("something went wrong !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
		
	}



