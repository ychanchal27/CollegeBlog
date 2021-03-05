package com.ips.collegeblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ips.collegeblog.entity.College;
import com.ips.collegeblog.entity.Student;

public class StudentDao {
	private Connection con;
	
	public StudentDao(Connection con)
	{
		super();
		this.con=con;
	}
	public boolean saveStudent(Student student)
	{
		boolean f=false;
		try {
			String query= "insert into studentdb(studentName,studentEmail,contactNumber,password) values(?,?,?,?)";
			PreparedStatement pstmt=this.con.prepareStatement(query);
			pstmt.setString(1,student.getStudentName());
			pstmt.setString(2, student.getStudentEmail());
			pstmt.setString(3,student.getContactNumber());
			pstmt.setString(4,student.getPassword());
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	public Student getStudentByEmailAndPassword(String studentEmail, String password) {
		// TODO Auto-generated method stub
		Student student=null;
		
		try
		{
			String query="select * from studentdb where studentEmail=? and password=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, studentEmail);
			pstmt.setString(2,password );
			ResultSet rs=pstmt.executeQuery();	
			if(rs.next())
			{
				student=new Student();
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentEmail(rs.getString("studentEmail"));
				student.setContactNumber(rs.getString("contactNumber"));
				student.setPassword(rs.getString("password"));
			}
			System.out.println("student at dao:"+student);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return student;
	}
	
	
	public boolean updateStudent(Student student, Integer id) {
		boolean f= false;
		try {
		String query= "update studentdb set studentName=?, studentEmail=? , contactNumber=?, password=? where id=?";
		PreparedStatement pstmt=this.con.prepareStatement(query);
		
		pstmt.setString(1,student.getStudentName());
		pstmt.setString(2,student.getStudentEmail());
		pstmt.setString(3,student.getContactNumber());
		pstmt.setString(4,student.getPassword());
		pstmt.setInt(5,id);
		
		pstmt.executeUpdate();
		f=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
	

}
