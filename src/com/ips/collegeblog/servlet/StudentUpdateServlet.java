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
import com.ips.collegeblog.dao.StudentDao;
import com.ips.collegeblog.entity.College;
import com.ips.collegeblog.entity.Student;
import com.ips.collegeblog.helper.ConnectionProvider;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
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
		try(PrintWriter out= response.getWriter())
		{
			String studentName=request.getParameter("name");
			String studentEmail=request.getParameter("email");
			String contactNumber=request.getParameter("contact");
			String password=request.getParameter("pass");
			System.out.println( "updatestudent"+" "+studentName+" "+studentEmail+" "+contactNumber+" "+ password);
			
			
			Student student=new  Student( studentName, studentEmail, contactNumber, password);
			
			HttpSession s= request.getSession();
			Student st= (Student) s.getAttribute("currentstudent");
			String collegeName= st.getStudentName();
			Integer id= st.getId();

		
			
			StudentDao dao= new StudentDao(ConnectionProvider.getConn());
			if(dao.updateStudent(student,id)) {
				out.print("done");
			}else {
				out.print("something went wrong !");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
