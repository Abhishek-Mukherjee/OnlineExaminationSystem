<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
  <!-- CORE CSS-->
  
  <link rel="stylesheet" href="style.css">

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

<body class="red">


  <div id="login-page" class="row" style="margin-top: 60px;">
    <div class="col s12 z-depth-6 card-panel">
     <!-- ##################################### FORM ############################################### -->
     
      <form class="login-form" action="clientlogin" method="post">
        <div class="row">
          <div class="input-field col s12 center">
            <p class="center login-form-text">PLEASE LOG IN HERE</p>
          </div>
        </div>
        
        <div class="row margin">
          <div class="input-field col s12">
            <input class="validate"  type="text" name="ex_num">
            <label for="email" data-error="wrong" data-success="right" class="center-align">Enter Examination Number</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <input id="password" type="password" name="pass">
            <label for="password">Password</label>
          </div>
        </div>
        
        <div class="row">
          <div class="input-field col s12">
            <input type="submit" class="btn btn-success" value="LOGIN">
          </div>
        </div>

      </form>
    </div>
  </div>
<div>
<%
if(request.getAttribute("massage")!= null)
	out.println("<h3>"+request.getAttribute("massage").toString()+"</h3>");
%>
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
            © Majore Project
            <a class="grey-text text-lighten-4 right" href="#"></a>
            </div>
          </div>
  </footer>
</body>

</html>
