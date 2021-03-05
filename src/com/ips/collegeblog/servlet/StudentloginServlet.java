package com.ips.collegeblog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ips.collegeblog.dao.StudentDao;
import com.ips.collegeblog.entity.Student;
import com.ips.collegeblog.helper.ConnectionProvider;

/**
 * Servlet implementation class StudentloginServlet
 */
@WebServlet("/StudentloginServlet")
public class StudentloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter out =response.getWriter())
		{
			String studentEmail=request.getParameter("studentEmail");
			String password=request.getParameter("password");
			System.out.println(studentEmail+" "+password);
			StudentDao dao=new StudentDao(ConnectionProvider.getConn()); 
			Student student = dao.getStudentByEmailAndPassword(studentEmail,password);
			System.out.println("student at login servlet:"+student);
			if(student==null)
			{
				out.print("invalid studentemail and password");
			}
			else
			{
				System.out.print("logged in user detail:"+student);
				HttpSession s= request.getSession();
				s.setAttribute("currentstudent",student);
				response.sendRedirect("BlogStudent.jsp");
			}
			
			
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	}

}
