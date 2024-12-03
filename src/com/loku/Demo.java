package com.loku;





import java.sql.DriverManager;

import java.sql.Connection;

public class Demo 
{
	static Connection con=null;
	public static Connection getConnect()
	{
		try {
			Class .forName("com.mysql.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/eportal","root","");
		} catch (Exception e) 
		{
			System.out.println(e);
			e.printStackTrace();
		} 
		return con;
		}

}
