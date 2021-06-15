<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="clientDao.DataAccess" %>
<!DOCTYPE html>
<html>
<head>
	<title>h</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<style type="text/css">	
	div{
	  background-color:grey;
	  color: white;
	  font-size:20px;
	  text-align:center;
	  width: 100px;
	  height: 10px;
	  padding: 60px;
	  float: right;
	}
	</style>
</head>
<body>

<%
	//########  FOR USER AUTHENTICATION ####################################
	 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	if(session.getAttribute("ex_num")==null){
		response.sendRedirect("Clientlogin.jsp");
	}else{
%>


<div class="container-fluid" style="background-color: grey;">
	<DIV class="row">
		<div class="col-md-offset-2 col-md-10">
			<h1 style="letter-spacing: .8em; color: white;">ONLINE EXAMINATION</h1>
		</div>
	</DIV>
	<div class="row">
		<div class="col-md-offset-4">
			<h1 style="letter-spacing: .8em; color: white;">SYSTEM</h1>
		</div>
	</div>
</div>

<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& QUESTION SECTION &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->

<div class="row">
	<div class="col-md-offset-3 col-md-6">
		<form method="post" action="clientquestion">
			<%
			//##################################### MAIN CODE STARTS HERE #############################
			
			String ex_num = (String)session.getAttribute("ex_num");
			
			DataAccess obj = new DataAccess();
			ResultSet rs = obj.showques(ex_num);
			ResultSet r = obj.marks0feach(ex_num);
			r.next();
			int time = r.getInt(4);
			int t=1; 
			while(rs.next())
			{
			
			%>
			<fieldset>
				<legend>Question</legend>
				<label><h2><%=rs.getString(3) %></h2></label>
				
				<div class="checkbox"><label><input type="checkbox" name="question<%= t %>" value="1"><%=rs.getString(4) %></label></div>
				<div class="checkbox"><label><input type="checkbox" name="question<%= t %>" value="2"><%=rs.getString(5) %></label></div>
				<div class="checkbox"><label><input type="checkbox" name="question<%= t %>" value="3"><%=rs.getString(6) %></label></div>
				<div class="checkbox"><label><input type="checkbox" name="question<%= t %>" value="4"><%=rs.getString(7) %></label></div>
			</fieldset>
			<%
					t++;
					}
				}
			%>
			<input type="submit" value="Submit">
			</form>				
	</div>
</div>



<div class="container-fluid" style="background-color: grey;">
	<h3>Developed By RS QUBE</h3>
</div>
<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>