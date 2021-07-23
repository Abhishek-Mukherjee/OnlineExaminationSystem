<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Signup / Registration form using Material Design - Demo by W3lessons</title>
  <!-- CORE CSS-->
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">

<style type="text/css">
html,
body {
    height: 100%;
}
html {
    display: table;
    margin: auto;
}
body {
    display: table-cell;
    vertical-align: middle;
}
.margin {
  margin: 0 !important;
}
</style>
  
</head>

<body class="blue">
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("ex_num")==null){
		response.sendRedirect("Clientlogin.jsp");
	}
%>


  <div id="login-page" class="row">
    <div class="col s12 z-depth-6 card-panel">
      
      <!-- ##################FORM STARTS HERE######################################## -->

      <form class="login-form" action="clientdetails" method="post">
       
        <div class="row">
          <div class="input-field col s12 center">
            <p class="center login-form-text">REGISTER YOUR DETAILS</p>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <input id="username" type="text" class="validate" name="name">
            <label for="username" class="center-align">NAME</label>
          </div>
        </div>
        
        <div class="row margin">
          <div class="input-field col s12">
            <input id="email" type="email" class="validate" name="email">
            <label for="email" class="center-align">Email</label>
          </div>
        </div>
        
        <div class="row margin">
          <div class="input-field col s12">
            <input id="phone" type="text" class="validate" name="phone">
            <label for="phone" class="center-align">Phone Number</label>
          </div>
        </div>
        
        <div class="input-field col s12">
            <input type="submit" value="SUBMIT" class="btn">
          </div>
      
        </div>
      </form>
    </div>
  </div>


 
  <!-- ================================================
    Scripts
    ================================================ -->

  <!-- jQuery Library -->
 <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!--materialize js-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>




   <footer class="page-footer">
          <div class="footer-copyright">
            <div class="container">
            ©  MAJOR PROJECT
            <a class="grey-text text-lighten-4 right" href="#">MAJOR  PROJECT</a>
            </div>
          </div>
  </footer>
</body>

</html>