<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
 <%@taglib uri="/struts-tags" prefix="s" %> 
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/LoginStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
 </head>
 
  <body>
	<div class="align">
		
		<div class="card">
			<div class="head">		
				<div
				></div>
				<a id="login" class="selected" href="#login">Admin Login</a>
				<a id="register" href="#register">...</a>
				<div></div>
				
			</div>
			<div class="tabs">
 			 <s:form action="adminLogin">
					<div class="inputs">
						<div class="input">
							<input placeholder="Username" name="userName">
							<img src="../img/user.svg">
						</div>
						<div class="input">
							<input type="password" placeholder="Password"  name="password">
							<img src="../img/pass.svg">
						</div>
						<label class="checkbox">
							<input type="checkbox">
							<span>Remember me</span>
						</label>
					</div>
					<button type="submit" class="btn" value="Login">Login</button>
 				 </s:form>
			</div>
		</div>
	</div>
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/index.js"></script>


  </body>
</html>


