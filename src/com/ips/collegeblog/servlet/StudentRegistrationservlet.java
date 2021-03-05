package com.ips.collegeblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ips.collegeblog.dao.CollegeDao;
import com.ips.collegeblog.dao.StudentDao;
import com.ips.collegeblog.entity.College;
import com.ips.collegeblog.entity.Student;
import com.ips.collegeblog.helper.ConnectionProvider;

/**
 * Servlet implementation class StudentRegistrationservlet
 */
@WebServlet("/StudentRegistrationservlet")
public class StudentRegistrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationservlet() {
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
			String studentName =request.getParameter("studentName");
			String studentEmail=request.getParameter("studentEmail");
			String contactNumber=request.getParameter("contactNumber");
			String password=request.getParameter("password");
			
			Student student= new Student(studentName,studentEmail, contactNumber, password);
			System.out.println(student);
			// creating studentDao object...
			StudentDao dao= new StudentDao(ConnectionProvider.getConn());
			if(dao.saveStudent(student)) {
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


