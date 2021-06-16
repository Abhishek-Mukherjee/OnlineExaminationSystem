<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="clientDao.DataAccess" %>
<!DOCTYPE html>
<html>
<head>
	<title>EXAM</title>
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

<!-- &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& QUESTION SECTION &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& -->

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
</body>
</html>