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
 * Servlet implementation class PostBlogServlet
 */
@WebServlet("/PostBlogServlet")
public class PostBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostBlogServlet() {
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
			String title =request.getParameter("title");
			String topic=request.getParameter("topic");
			String postblog=request.getParameter("postblog");
			
		
			HttpSession s= request.getSession();
			College college= (College)s.getAttribute("currentUser");
			Integer collegeid = college.getId();
			
			System.out.println(collegeid+" "+title+" "+topic+" "+postblog);
			
			PostBlog postbg= new PostBlog(collegeid, title, topic, postblog);
			
			PostblogDao dao= new PostblogDao(ConnectionProvider.getConn());
			if(dao.blogPost(postbg)) {
				out.print("done");
			}
			else {
				out.print("something went wrong !");
			}
		}catch(Exception e)
			{
				e.printStackTrace();
			}

		}

}
