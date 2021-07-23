<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>h</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>

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
<div class="row">
	<div class="col-md-offset-3 col-md-6">
		<form action="adminquestion" method="post">
<%
//*********************************************note---------------------send the examination number and question id also************
String q = session.getAttribute("number_question").toString();
int i = Integer.parseInt(q);
int t; 
for(t=1;t<=i;t++){
%>
		<fieldset>
			<legend><H1>Question</H1></legend>
			<label>Question</label><textarea rows="2" cols="80" name="question<%= t %>"></textarea></br></br></br>
			<label>OPTION 1</label><input type="text" name="1opt<%= t %>" style="width: 250px;"></br></br>
			<label>OPTION 2</label><input type="text" name="2opt<%= t %>" style="width: 250px;"></br></br>
			<label>OPTION 3</label><input type="text" name="3opt<%= t %>" style="width: 250px;"></br></br>
			<label>OPTION 4</label><input type="text" name="4opt<%= t %>" style="width: 250px;"></br></br>
			<select name="ans<%=t%>">
				<option>Please select the correct option</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
		</fieldset>
<%
}
%>
<input type = "submit" value="submit">
</form>

		
	</div>
</div>
<div class="container-fluid" style="background-color: grey;">
	<h3>Developed By ASD</h3>
</div>
<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>