


package com.ips.collegeblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ips.collegeblog.entity.College;

public class CollegeDao {

	private Connection con;

	public CollegeDao(Connection con) {
		super();
		this.con = con;
	}
	

	public boolean saveCollege(College college) {
		boolean f= false;
		try {
		String query= "insert into collegedb(collegeName,facultyName,emailAddress,password) values(?,?,?,?)";
		PreparedStatement pstmt=this.con.prepareStatement(query);
		pstmt.setString(1,college.getCollegeName());
		pstmt.setString(2,college.getFacultyName());
		pstmt.setString(3,college.getEmailAddress());
		pstmt.setString(4,college.getPassword());
		pstmt.executeUpdate();
		f=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return f;
		
	}


	public College getUserByEmailAndPassword(String emailAddress, String password) {
		College college= null;
		
		try
		{
			String query="select * from collegedb where emailAddress=? and  password=?";
			PreparedStatement pstmt= con.prepareStatement(query);
			pstmt.setString(1, emailAddress);
			pstmt.setString(2, password);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				college= new College();
				college.setId(rs.getInt("id"));
				college.setCollegeName(rs.getString("collegeName"));
				college.setFacultyName(rs.getString("facultyName"));
				college.setEmailAddress(rs.getString("emailAddress"));
				college.setPassword(rs.getString("password"));
			}
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return college;
	}
	
	
	
	public boolean updateFaculty(College college, Integer id) {
		boolean f= false;
		try {
		String query= "update collegedb set  emailAddress=?, facultyName=? , password=? where id=?";
		PreparedStatement pstmt=this.con.prepareStatement(query);
		//pstmt.setString(1,college.getCollegeName());
		pstmt.setString(2,college.getFacultyName());
		pstmt.setString(1,college.getEmailAddress());
		pstmt.setString(3,college.getPassword());
		pstmt.setInt(4,id);
		pstmt.executeUpdate();
		f=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
}
