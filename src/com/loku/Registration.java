package com.loku;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loku.Demo;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		try{
			String emailid=request.getParameter("emailid");
			String pass=request.getParameter("pass");
			System.out.println(emailid);
			System.out.println(pass);
			
			
			Connection con=Demo.getConnect();
			PreparedStatement pstmt=con.prepareStatement("insert into login values(?,?,?)");
			 pstmt.setString(1, emailid);
				pstmt.setString(2, pass);
				pstmt.setString(3, "Admin");
			
			int i=pstmt.executeUpdate();
			if(i>0)
			{
					response.sendRedirect("admin.html");
			
			}
			else 
			{
				response.sendRedirect("registration.html");
			}
				
			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	

	}



