<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="admindao.Dao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="get">
<%
if(session.getAttribute("login")==null){
	response.sendRedirect("login.jsp");
}
String ex_num = request.getParameter("update");
HttpSession ses = request.getSession();
ses.setAttribute("ex_num", ex_num);
Dao obj = new Dao();
ResultSet rs = obj.fetchques(ex_num);
int t = 1;
if(rs.isBeforeFirst())
{
		while(rs.next())
		{
		%>
			<fieldset>
					<legend><H1>Question</H1></legend>
					<label>Question</label><textarea rows="2" cols="80" name="question<%= t %>"><%=rs.getString(3) %></textarea></br></br></br>
					<label>OPTION 1</label><input type="text" name="1opt<%= t %>" style="width: 250px;" value="<%=rs.getString(4) %>"></br></br>
					<label>OPTION 2</label><input type="text" name="2opt<%= t %>" style="width: 250px;" value="<%=rs.getString(5) %>"></br></br>
					<label>OPTION 3</label><input type="text" name="3opt<%= t %>" style="width: 250px;" value="<%=rs.getString(6) %>"></br></br>
					<label>OPTION 4</label><input type="text" name="4opt<%= t %>" style="width: 250px;" value="<%=rs.getString(7) %>"></br></br>
					<select name="ans<%=t%>">
						<option>Please select the correct option</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
			</fieldset>
		<%
		t++;
		}
		%>
	<input type="submit" value="Update">
	</form>
	<%
}
else
{
	request.setAttribute("mas", "PLEASE CHECK YOUR EXAMINATION NUMBER");
	RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
	rd.forward(request, response);
}
%>

<a href="Welcome.jsp">HOME</a>

<!-- LOGOUT BUTTON  -->
	<form action="logout" method="post">
		<input type="submit" value="LOG OUT">
	</form>
</body>
</html>