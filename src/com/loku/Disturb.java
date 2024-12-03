package com.loku;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Disturb
 */
@WebServlet("/Disturb")
public class Disturb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Disturb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String comment=request.getParameter("comment");
		System.out.println(comment);
		int aid=Integer.parseInt(request.getParameter("aid"));
		System.out.println(aid);

		int pid=Integer.parseInt(request.getParameter("pid"));
		int did=Integer.parseInt(request.getParameter("did"));
		System.out.println(aid);
		System.out.println(pid);
		System.out.println(did);
		System.out.println(comment);
		try
		{			
			
		
			Connection con21=Demo.getConnect();
					PreparedStatement ps5=con21.prepareStatement("insert into  comments values(?,?,?,?,?)");
					ps5.setInt(1,pid);
					ps5.setInt(1,did);
					ps5.setInt(1,aid);
					ps5.setString(4, comment);
					ps5.setString(5, "None");
					System.out.println(aid);
					System.out.println(pid);
					System.out.println(did);
					System.out.println(comment);
			
					
					
					int i=ps5.executeUpdate();
					if(i>0)
					{
						response.sendRedirect("viewcase.jsp");
					}
				
			
				}
		        catch(Exception e)
		        {
		                   	e.printStackTrace();
	            }	
	}

}
