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

import com.loku.Demo;
import com.loku.Getters;

/**
 * Servlet implementation class sim
 */
@WebServlet("/sim")
public class sim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sim() {
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
		doGet(request, response);try
		{			
			String pname=request.getParameter("pname");
			String age =request.getParameter("age");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String MoNo=request.getParameter("MoNo");
		String sym1=request.getParameter("sym1");
		String sym2=request.getParameter("sym2");
		String sym3=request.getParameter("sym3");
		/*System.out.println(pname);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(address);
		System.out.println(MoNo);
		System.out.println(sym1);
		System.out.println(sym2);
		System.out.println(sym3);
		System.out.println(Getters.getDid());
		System.out.println(Getters.getAvid());
		System.out.println(Getters.getPid());
		System.out.println("====================================================");*/
		
		
		Connection con77=Demo.getConnect();
		PreparedStatement pstmt33=con77.prepareStatement("select Disease from dataset1 where Symptom_1=? and Symptom_2=? and Symptom_3=?");
		pstmt33.setString(1,sym1);
		 pstmt33.setString(2,sym2);
		 pstmt33.setString(3,sym3);
		ResultSet rs49=pstmt33.executeQuery();
			
		
			while(rs49.next())
			{
				
				String Disname=rs49.getString(1);
				Getters.setDisname(Disname);
				
				
				
			}
			
				Connection con90 =Demo.getConnect();
				PreparedStatement pstmt20=con90.prepareStatement("select * from  specialistdoctor where specialization=? order by did desc");                                   //ORDER BY RANDOM()
				pstmt20.setString(1,Getters.getDisname());
				
				ResultSet rs9=pstmt20.executeQuery();
			
				while(rs9.next())
				{
					int did=rs9.getInt(1);
					 Getters.setDid(did);
						/*System.out.println(did);*/
				}
				String AVcomment=null;
				String DComment=null;
					Connection con21=Demo.getConnect();
					PreparedStatement ps5=con21.prepareStatement("insert into  casestudy values(?,?,?,?,?,?,?,?,?,?,?,?)");
					ps5.setInt(1,Getters.getPid());
					ps5.setString(2, pname);
					ps5.setString(3, age);
					ps5.setString(4, gender);
					ps5.setString(5, address);
					ps5.setString(6, MoNo);
					ps5.setString(7, sym1);
					ps5.setString(8, sym2);
					ps5.setString(9, sym3);
					ps5.setInt(10, Getters.getAvid());
					ps5.setString(11,Getters.getDisname());
					ps5.setInt(12, Getters.getDid());
					
					
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
