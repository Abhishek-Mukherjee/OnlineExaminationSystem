
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="admindao.Dao"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ASD SYSEM</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="styles/style.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>
<body class="page">

<%
	 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	if(session.getAttribute("login")==null){
		response.sendRedirect("login.jsp");
	}
%>

<div id="wrap">
  <div id="header">
    <h1><a href="#">ASD SYSTEM</a></h1>

  
   <!--START NAM-->
    <div id="nav">
      <ul class="menu">
        <li class="current_page_item"><a href="newexam.jsp">NEW EXAM</a></li>
        	<li class="current_page_item"><form action="logout" method="post">
				<input type="submit" value="LOG OUT" class="btn">
			</form>
			</li>
      </ul>
    </div>

    <!--end nav-->
  </div>
  <!--end header-->
  <div id="featured-section">
    <h2>ONLINE EXAMINATION PLATFORM</h2>
    <div id="circles">
      <div class="red-circle circle first">
        <h3><em>ONLINE EXAM TIMER</em></h3>
        <p>1. INTRACTIVE ENVIORMENT<BR>2. EASY FLOW OF CONTROLL</p>
      </div>
      <!--end red-circle-->
      <div class="pink-circle circle">
        <h3><em>SECURE EXAM PROCESS</em></h3>
        <p>1. LIVE MONITORING<BR>2. RESPONSE ON CHEATING</p>
      </div>
      <!--end red-circle-->
      <div class="orange-circle circle">
        <h3><em>QUICK RESULT</em></h3>
        <p>1. FAST RESULT SET<BR>2. INTERACTIVE REPRESENTATION</p>
      </div>
      <!--end red-circle-->
      <div class="yellow-circle circle">
        <h3><em>DESIGN YOUR EXAMINATION</em></h3>
        <p>1. HELD YOUR EXAMINATION<BR>2. MAKE YOUR OWN QUESTIONS</p>
      </div>
      <!--end red-circle-->
    </div>
    <!--end circles-->
  </div>
  <!--end featured-section-->
  <div id="frontpage-main">
    <div id="overview" class="frontpage-section">
      <h3>Exams Lists</h3>
      <p>Examination Number</p>
      <ul class="blue-bullets">
	 <% Dao obj = new Dao();
		String uname = (String)session.getAttribute("login");
		ResultSet rs = obj.listexam(uname);
		while(rs.next())
		{
	 %>
		<li><%out.println(rs.getString(1)); %></li>
     <%
		}
     %>
      </ul>
    </div>
    	<!--  ###########################VIEW EXAM LIST#############################  -->
   <div id="contact-form-container">
      <form id="contact-form" action="viewExam.jsp" method="get">
        <fieldset>
          <label>View Previous Exam Result</label>
          <input id="form_name" type="text" name="ex_num" placeholder="Enter Examination Number" />
          <input id="form_submit" class="submit" type="submit" name="submit" value="Submit &raquo;" />
        </fieldset>
      </form>
      <%
	if(request.getAttribute("massage")!=null){
		out.println("PLEASE CHECK YOUR EXAMINATION NUMBER");
	}
	%>
    </div>
        

    	<!--  ########################### View and Update Question set #############################  -->
   <div id="contact-form-container">
      <form id="contact-form" action="update.jsp">
        <fieldset>
          <label>View and Update Question Paper</label>
          <input id="form_name" type="text" name="update" placeholder="Enter Examination Number" onFocus="if(this.value=='Name'){this.value=''};" onBlur="if(this.value==''){this.value='Name'};" />

          <input id="form_submit" class="submit" type="submit" name="submit" value="Submit &raquo;" />
        </fieldset>
      </form>
      <%
	if(request.getAttribute("mas")!=null){
		out.println("PLEASE CHECK YOUR EXAMINATION NUMBER \n");
	}
	%>
	<a href="login.jsp">BACK</a>
    </div>
        

    <!--end frontpage-content-->
    
    <!--end frontpage-sidebar-->
  </div>
  <!--end frontpage-main-->
  <div id="footer">
    <p class="copyright">Copyright &copy; <a href="#">Domain Name</a> - All Rights Reserved / Design By ABHISHEK, SUSMITA, DEBOLINA</p>
    
  </div>
  <!--end footer-->
</div>
<!--end wrap-->
<div class="cache-images"> <img src="images/red-button-bg.png" width="0" height="0" alt="" /> </div>
<!--end cache-images-->
</body>
</html>