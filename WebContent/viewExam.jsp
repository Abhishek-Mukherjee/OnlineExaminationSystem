<%@page import="javax.servlet.annotation.WebServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="admindao.Dao"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

Dao obj = new Dao();
String ex_num = request.getParameter("ex_num");
ResultSet rs = obj.viewexam(ex_num);

		try 
		{		
					while(rs.next())
					{
						out.println("NAME             :-  "   +rs.getString(1));
						out.print("</br>");
						out.println("EMAIL             :-  "  +rs.getString(2));
						out.print("</br>");
						out.println("EX_NUM            :-  " +rs.getString(3));
						String email = rs.getString(2);
						out.print("</br>");
						out.println("MARKS             :-  "  +rs.getInt(4));
						out.print("</br>");
						out.println("<a href=\"detailreport?value1="+ex_num+"&value2="+email+"\">Details Report</a>"+" ");
						
						out.print("</br>");
						out.print("</br>");
						out.print("</br>");
						out.print("</br>");
					}							
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}	

%>
</body>
</html>