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
 * Servlet implementation class AddSDoctor
 */
@WebServlet("/AddSDoctor")
public class AddSDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSDoctor() {
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
			String dname=request.getParameter("dname");
			String emailid=request.getParameter("emailid");
			String MoNo=request.getParameter("MoNo");
			String city=request.getParameter("city");
			String specialization=request.getParameter("specialization");
			String pass=request.getParameter("pass");
			String DiseaseThreat=request.getParameter("DiseaseThreat");
			
			System.out.println("hello");
			Connection con2=Demo.getConnect();
			PreparedStatement pstmt13=con2.prepareStatement("insert into login values(?,?,?)");
			 pstmt13.setString(1, emailid);
				pstmt13.setString(2, pass);
				pstmt13.setString(3, "specialistdoctor");

				int k=pstmt13.executeUpdate();

				
				int did=0;
			

			
			
				Connection con=Demo.getConnect();
			PreparedStatement pstmt=con.prepareStatement("insert into specialistdoctor values(?,?,?,?,?,?,?,?)");
			 pstmt.setInt(1,did);
			pstmt.setString(2, dname);
			pstmt.setString(3, emailid);
			pstmt.setString(4, pass);
			pstmt.setString(5, MoNo);
			pstmt.setString(6, city);
			pstmt.setString(7, specialization);
			pstmt.setString(8, DiseaseThreat);
			
				

			
			System.out.println(DiseaseThreat);
			int i=pstmt.executeUpdate();
			if(i>0)
				
			{
					response.sendRedirect("admin.html");
			
			}
			else 
			{
				response.sendRedirect("addsdoctor.html");
			}
				
			
	
	
		}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}
	}
}


