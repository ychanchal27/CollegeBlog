package com.ips.collegeblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ips.collegeblog.entity.PostBlog;


public class PostblogDao {

private Connection con;

public PostblogDao(Connection con) {
	super();
	this.con = con;
}

public boolean blogPost(PostBlog postbg)
{
	boolean f=false;
	try {
		String query="insert into blogpost(collegeid,title,topic,post)values(?,?,?,?)";
		PreparedStatement pstmt=this.con.prepareStatement(query);
		pstmt.setInt(1,postbg.getCollegeid());
		pstmt.setString(2,postbg.getTitle());
		pstmt.setString(3,postbg.getTopic());
		pstmt.setString(4,postbg.getPostBlog());
		pstmt.executeUpdate();
		f=true;
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	return f;
}


public ArrayList<PostBlog> getAllPost()
{
	ArrayList<PostBlog> list=new ArrayList<>();
	try
	{
		PreparedStatement p=con.prepareStatement("select*from blogpost order by id desc");
		ResultSet set=p.executeQuery();
		
		while(set.next())
		{
			int id=set.getInt("id");
			int collegeid=set.getInt("collegeid");
			String title=set.getString("title");
			String topic=set.getString("topic");
			String postblog=set.getString("post");
			System.out.println("postblog "+id+" "+collegeid+ " "+title+" "+topic+ " "+postblog);
			
			
			PostBlog pb=new  PostBlog( id,collegeid,title, topic, postblog);
			list.add(pb);
		}
		
	}catch(Exception e)
	{
	e.printStackTrace();	
	}
	return list;
	
}



}
