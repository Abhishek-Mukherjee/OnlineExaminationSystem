<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Rokono | Contact</title>
<meta charset="utf-8">
<link type="text/css" rel="stylesheet" href="styles/style.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

</head>
<body class="page">
<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("login")==null){
		response.sendRedirect("login.jsp");
	}
%>
<div id="wrap">
  <div id="header">
    <h1><a href="#">RS Qube</a></h1>
    <div id="nav">
      <ul class="menu">
        <li><a href="Welcome.jsp">Home</a></li>
	     <li>
	     	<form action="logout" method="post">
				<input type="submit" value="LOG OUT" class="btn">
			</form>
		</li>
      </ul>
    </div>
    <!--end nav-->
  </div>
  <!--end header-->
  <div id="main">
    <div id="contact-details">
      <h3 class="title">INSTRUCTION</h3>
      <p>Please fillup the form carefully as the exam depends on the information provided Here</p>
      <h3>Details</h3>
      <h4>Examination Number: <span>[This EXAMINATION number is important for client side login]</span></h4>
      <h4>Password: <span>[This PASSWORD number is important for client side login]</span></h4>
      <h4>Number of Questions: <span>[Fill up how many questions you want to put]</span></h4>
      <h4>Time: <span>[Exam time]</span></h4>
      <h4>Marks of each Questions: <span>[Each question's mark is important to result genarate]</span></h4>
    </div>
    <!--end contact-details-->
    <div id="contact-form-container">
      <form id="contact-form" action="newExam" method="post">
        <fieldset>
          <label>PLEASE FILL THE EXAMDETAILS</label>
          <input  type="text" name="ex_num" placeholder="Examination Number"  />

          <input  type="text" name="pass" placeholder="Password"  />          

          <input type="text" name="time"  placeholder="Time"   />

          <input  type="text" name="num_ques"  placeholder="Number of Questions"  />

          <input  type="text" name="marks"  placeholder="Marks of each Questions" />

          <input type="text" name="date"  placeholder="Examination Date"/>
          
          <input class="submit" type="submit" value="submit" />
        </fieldset>
      </form>
    </div>
    <!--end contact-form-container-->
  </div>
  <!--end main-->
  <div id="footer">
    <p class="copyright">Copyright &copy; <a href="#">RS Qube</a> - All Rights Reserved / Design By Abhishek Mukherjee & Subham Panda <a target="_blank" href="http://www.chris-creed.com/">Chris Creed</a></p>
   </div>
  <!--end footer-->
</div>
<!--end wrap-->
<div class="cache-images"> <img src="images/red-button-bg.png" width="0" height="0" alt="" /> </div>
<!--end cache-images-->
</body>
</html>
    
