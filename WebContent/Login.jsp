<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
 <%@taglib uri="/struts-tags" prefix="s" %> 
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/LoginStyle.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
 </head>
 
  <body>
	<div class="align">
		<img style="margin-top:15px" class="logo" src="./img/logo.svg">
		<div class="card">
			<div class="head">		
				<div
				></div>
				<a id="login" class="selected" href="#login">Login</a>
				<a id="register" href="#register">Register</a>
				<div></div>
				
			</div>
			<div class="tabs">
 			 <s:form action="Login">
					<div class="inputs">
						<div class="input">
							<input placeholder="Username" name="userName">
							<img src="./img/user.svg">
						</div>
						<div class="input">
							<input type="password" placeholder="Password"  name="password">
							<img src="./img/pass.svg">
						</div>
						<label class="checkbox">
							<input type="checkbox">
							<span>Remember me</span>
						</label>
					</div>
					<button type="submit" class="btn" value="Login">Login</button>
 				 </s:form>
				<s:form action="Registration">
					<div class="inputs">
					 	<div class="input">
							<input placeholder="First name" name="firstname" type="Name">
							<img src="./img/pass.svg">
						</div>
						<div class="input">
							<input placeholder="Last name" name="lastname" type="Prenom">
							<img src="./img/pass.svg">
						</div> 
						<div class="input">
							<input placeholder="email" name="email" type="text">
							<img src="./img/mail.svg">
						</div>
						<div class="input">
							<input placeholder="username" name="userName" type="text">
							<img src="./img/user.svg">
						</div>
						<div class="input">
							<input placeholder="password" name="password" type="password">
							<img src="./img/pass.svg">
						</div>
						<div class="input">
							<input placeholder="Adresse" name="adress" type="Adresse">
							<img src="./img/pass.svg">
						</div>
						<div class="input">
							<input placeholder="Birth date" name="bdate" type="Birth date">
							<img src="./img/pass.svg">
						</div>		
					</div>
					<button type="submit" class="btn" value="adminLogin">>Register</button>
				</s:form>
			</div>
		</div>
	</div>
	<script src="./js/jquery-3.3.1.min.js"></script>
	<script src="./js/index.js"></script>


  </body>
</html>


