<%@ page import ="com.loku.*" %>
<%@ page import ="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Popup Login Form Design | CodingNepal</title>
      <link rel="stylesheet" href="style.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
      <style >
      @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
*{
  margin: 0;
  padding: 0;
  outline: none;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
body{
  height: 100vh;
  width: 100%;
  background: linear-gradient(115deg, #56d8e4 10%, #9f01ea 90%);
}
.show-btn{
  background: #fff;
  padding: 10px 20px;
  font-size: 20px;
  font-weight: 500;
  color: #3498db;
  cursor: pointer;
  box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
}
.show-btn, .container{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
input[type="checkbox"]{
  display: none;
}
.container{
 
  background: #fff;
  width: 410px;
  padding: 30px;
  box-shadow: 0 0 8px rgba(0,0,0,0.1);
}
#show:checked ~ .container{
  display: block;
}
.container .close-btn{
  position: absolute;
  right: 20px;
  top: 15px;
  font-size: 18px;
  cursor: pointer;
}
.container .close-btn:hover{
  color: #3498db;
}
.container .text{
  font-size: 35px;
  font-weight: 600;
  text-align: center;
}
.container form{
  margin-top: -20px;
}
.container form .data{
  height: 45px;
  width: 100%;
  margin: 40px 0;
}
form .data label{
  font-size: 18px;
}
form .data input{
  height: 100%;
  width: 100%;
  padding-left: 10px;
  font-size: 17px;
  border: 1px solid silver;
}
form .data input:focus{
  border-color: #3498db;
  border-bottom-width: 2px;
}
form .forgot-pass{
  margin-top: -8px;
}
form .forgot-pass a{
  color: #3498db;
  text-decoration: none;
}
form .forgot-pass a:hover{
  text-decoration: underline;
}
form .btn{
  margin: 30px 0;
  height: 45px;
  width: 100%;
  position: relative;
  overflow: hidden;
}
form .btn .inner{
  height: 100%;
  width: 300%;
  position: absolute;
  left: -100%;
  z-index: -1;
  background: -webkit-linear-gradient(right, #56d8e4, #9f01ea, #56d8e4, #9f01ea);
  transition: all 0.4s;
}
form .btn:hover .inner{
  left: 0;
}
btn button{
  height: 100%;
  width: 100%;
  background: none;
  border: none;
  color: #fffff;
  font-size: 18px;
  font-weight: 500;
  text-transform: uppercase;
  letter-spacing: 1px;
  cursor: pointer;
}
form .signup-link{
  text-align: center;
}
form .signup-link a{
  color: #3498db;
  text-decoration: none;
}
form .signup-link a:hover{
  text-decoration: underline;
}

      </style>
      
   </head>

<body>
<center>
	<H1><b>Case</b></H1>
	<table BORDER="50">
			
			
			<tr>
			<th>Patient ID:</th>
			<th>Patient Name:</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Address</th>
			<th>patient Mobile Number</th>
			<th>Symptom 1</th>
			<th>Symptom 2</th>
			<th>Symptom 3</th>
			<th>Aarogya vibhag id</th>
			<th>patient Disease</th>
			<th>Doctor id</th>
			
			</tr>
			
			<%
			try{
				Connection con= Demo.getConnect();
			PreparedStatement pstmt=con.prepareStatement("select * from casestudy");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
			%>
			<tr>
			<td><%=rs.getInt(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getString(4) %></td>
			<td><%=rs.getString(5) %></td>
			<td><%=rs.getString(6) %></td>
			<td><%=rs.getString(7) %></td>
			<td><%=rs.getString(8) %></td>
			<td><%=rs.getString(9) %></td>
			<td><%=rs.getInt(10) %></td>
			<td><%=rs.getString(11) %></td>
			<td><%=rs.getInt(12) %></td>
	
			</tr>
		<%
			
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			%>	
			
			</table>
			</center><br>
             <center>
               <div class="bn">
                  <div class="inner" ></div>
              <a href="aarogyaibhag.html">
                  <button type="button" style="background-color:red; border-color:blue;  width: 10%; height: 5vh; color:white">Back</button>
               </div>
               </center>
                </div>
		
			</center>
</body>
</html>