<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Menu</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link href="${pageContext.request.contextPath}/css/User_menu_style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	charset="utf-8"></script>
</head>
<body>
	<s:url action='childsList' />
	<input type="checkbox" id="check">
	<!--header area start-->
	<header> <label for="check"> <i class="fas fa-bars"
		id="sidebar_btn"></i>
	</label>
	<div class="left_area">
		<h3>
			Pro <span>Natation</span>
		</h3>
	</div>
	<div class="right_area">
		<a href="#" class="logout_btn">Logout</a>
	</div>
	</header>
	<!--header area end-->
	<!--mobile navigation bar start-->
	<div class="mobile_nav">
		<div class="nav_bar">
			<img src="${pageContext.request.contextPath}/img/avatar.png"
				class="mobile_profile_image" alt=""> <i
				class="fa fa-bars nav_btn"></i>
		</div>
		<div class="mobile_nav_items">
			<a href="#"><i class="fas fa-desktop"></i><span>Dashboard</span></a>
			<a href="#"><i class="fas fa-cogs"></i><span>Components</span></a> <a><i
				class="fas fa-table"></i><span>Tables</span></a> <a href="#"><i
				class="fas fa-th"></i><span>Forms</span></a> <a href="#"><i
				class="fas fa-info-circle"></i><span>About</span></a> <a href="#"><i
				class="fas fa-sliders-h"></i><span>Settings</span></a>
		</div>
	</div>
	<!--mobile navigation bar end-->
	<!--sidebar start-->
	<div class="sidebar">
		<div class="profile_info">
			<img src="${pageContext.request.contextPath}/img/avatar.png"
				class="profile_image" alt="">

			<h4 style="color: white">
				<s:property value="userName" />
			</h4>
			<s:set var="sessionUsername" value="userName" />
		</div>
      <a id="RegisterUserCoursePage" href="<s:url action="redirectUserCourseRegistration.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i class="fas fa-desktop"></i><span>S'inscrire a un cours</span></a>
      <a id="RegisterChildCoursePage" href="<s:url action="childsList.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i class="fas fa-cogs"></i><span>Inscrire mon enfant</span></a>      
      <a id="RegisterChildPage" href="<s:url action="redirectAddChild.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i class="fas fa-table"></i><span>Ajouter un enfant</span></a>
      <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
	</div>
	<!--sidebar end-->

	<div class="content">
	
	<br/>


		<h1>M'inscrire a un cours</h1>


		<div class="CourseSelection">

			<s:form action="UserCourseRegistration">

				<s:hidden name="user.userName" value="%{#sessionUsername}" />
				<s:hidden name="UserInscription" value="true" />

				<div class="select">
					<select name="course.courseLevel" id="format">
						<option selected disabled>Choisissez un cours</option>
						<option value="Etoile_de_mer">Étoile de mer</option>
						<option value="Bambins">Bambins</option>
						<option value="Tortues">Tortues</option>
						<option value="Pingouins">Pingouins</option>
						<option value="Salamandre">Salamandre</option>
						<option value="Baleines">Baleines</option>
						<option value="Grenouilles">Grenouilles</option>
						<option value="Dauphins">Dauphins</option>
						<option value="Maitre_Nageur">Maître-Nageur</option>

					</select>
				</div>
					<br/>
				
							<div class="buttons">
				  <div class="button-container">
				          <button class="btn effect01" type="submit" class="btn" value="UserCourseRegistration">Register</button>
				  </div>
				</div>

			</s:form>


		</div>

	</div>


</body>
</html>
