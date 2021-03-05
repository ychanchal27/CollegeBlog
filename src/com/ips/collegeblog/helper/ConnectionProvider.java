package com.ips.collegeblog.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
		private static Connection conn;
		public static Connection getConn()
		{
			try
			{
				if(conn==null)
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeblog","root","");
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return conn;
		}
}


