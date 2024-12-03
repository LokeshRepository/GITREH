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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		System.out.println("ello");
try {
			
			String emailid=request.getParameter("emailid");
			String pass=request.getParameter("pass");
			String User=request.getParameter("User");
			System.out.println(emailid);System.out.println(pass);System.out.println(User);
				
				Connection con=Demo.getConnect();
				PreparedStatement pstmt=con.prepareStatement("select * from login where emailid=? and pass=? and User=?");
				 pstmt.setString(1, emailid);
				pstmt.setString(2, pass);
				pstmt.setString(3, User);
			
				
				ResultSet rs =pstmt.executeQuery();
				System.out.println(emailid);System.out.println(pass);System.out.println(User);
				
					while(rs.next())
					{
				
					if(User.equals("Admin"))
							{
						response.sendRedirect("admin.html");
							}
					else if(User.equals("Aarogya Vibhag"))
					{
						System.out.println("nodo");
						Connection con22=Demo.getConnect();
						PreparedStatement pstmt33=con22.prepareStatement("select avid from aarogyavibhag where emailid=? and pass=?");
						 pstmt33.setString(1,emailid);
						 pstmt33.setString(2,pass);
						ResultSet rs4=pstmt33.executeQuery();
						
						System.out.println("Hello");
						while(rs4.next())
							{
							int avid=rs4.getInt(1);
							Getters.setAvid(avid);
						System.out.println(avid);
						System.out.println("Hello");
							}
						response.sendRedirect("aarogyaibhag.html");
				
						
					}
					else if(User.equals("specialistdoctor"))
					{
						Connection con22=Demo.getConnect();
						PreparedStatement pstmt33=con22.prepareStatement("select did from specialistdoctor where emailid=? and pass=?");
						 pstmt33.setString(1,emailid);
						 pstmt33.setString(2,pass);
						ResultSet rs4=pstmt33.executeQuery();
						
						
						while(rs4.next())
							{
							int spdid=rs4.getInt(1);
							Getters.setSpdid(spdid);
							System.out.println(spdid);
							}
						
						response.sendRedirect("specialistdoctor.html");
						
							
					}
					else 
				{
						
					response.sendRedirect("index.html");
				}
			}
					}
			catch (Exception e) {
				
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	



	





	}


