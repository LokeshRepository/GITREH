package com.loku;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		
		System.out.println("zello");

		try{
			String name=request.getParameter("name");
			String emailid=request.getParameter("emailid");
			String MoNo=request.getParameter("MoNo");
			String village=request.getParameter("village");
			String district=request.getParameter("district");
			String pass=request.getParameter("pass");
			System.out.println(name);
			System.out.println(emailid);

			
			Connection con1=Demo.getConnect();
			PreparedStatement pstmt12=con1.prepareStatement("insert into login values(?,?,?)");
			 pstmt12.setString(1, emailid);
				pstmt12.setString(2, pass);
				pstmt12.setString(3, "Aarogya Vibhag");

				int j=pstmt12.executeUpdate();

			int avid=0;
			Connection con=Demo.getConnect();
			PreparedStatement pstmt=con.prepareStatement("insert into aarogyavibhag values(?,?,?,?,?,?,?)");
			    pstmt.setInt(1, avid);
			    pstmt.setString(2, name);
			    pstmt.setString(3, emailid);
				pstmt.setString(4, MoNo);
				pstmt.setString(5, pass);
				pstmt.setString(6, village);
				pstmt.setString(7, district);
		
			int t=pstmt.executeUpdate();
			if(t>0)
			{
					response.sendRedirect("admin.html");
			
			}
			else 
			{
				response.sendRedirect("addaarogyv.html");
			}
				
			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
	}

}
