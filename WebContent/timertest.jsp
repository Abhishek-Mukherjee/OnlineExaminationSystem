<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.pool.OracleDataSource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="admindao.Dao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int time=0;
OracleDataSource ods;
		try {
			 ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ods.setUser("SYSTEM");
			ods.setPassword("manager");
			Connection con = ods.getConnection();
			

%>
<div id="timer">00:00:00</div>
<script type="text/javascript">

function timer()
{
	console.log("start");
	<% 
		PreparedStatement pstm = con.prepareStatement("Select *from timertest where ex_num=?");
		pstm.setString(1, "abc");
		ResultSet rs = pstm.executeQuery();
		rs.next();
		time=rs.getInt("time");
	%>
  console.log("get time value");
  var count = <% out.println(time);%>
  if(count>0)
  {
  var element = document.getElementById("timer"); 
  var hours = Math.floor(count/3600);
  var minutes = Math.floor((count/60)%60);
  var seconds = Math.floor(count%60);
  element.innerHTML= "<h3>your time:: &nbsp &nbsp "+hours+":"+minutes+":"+seconds+":"+"</h3>";
  <% 
  PreparedStatement pstmt = con.prepareStatement("update timertest set time=? where ex_num=?");
  time=time-1;
  pstmt.setInt(1, time);
  pstmt.setString(2, "abc");
  pstmt.executeUpdate();
  System.out.println("updated");
  %>
  console.log("update time value");
  }
  else
  {
    alert("Times UP");
    clearInterval(setinterval);
  }
}
var setinterval = setInterval(timer,1000);
</script>
<%
		} 
		catch (Exception e)
		{
		System.out.println(e);
		System.out.println("Connection to DB unsuccessful");
		}
%>
</body>
</html>