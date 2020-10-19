<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Menu</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/User_menu_style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
  </head>
  <body>
<s:url action='childsList'/>
    <input type="checkbox" id="check">
    <!--header area start-->
    <header>
      <label for="check">
        <i class="fas fa-bars" id="sidebar_btn"></i>
      </label>
      <div class="left_area">
        <h3>Pro <span>Natation</span></h3>
      </div>
      <div class="right_area">
        <a href="#" class="logout_btn">Logout</a>
      </div>
    </header>
    <!--header area end-->
    <!--mobile navigation bar start-->
    <div class="mobile_nav">
      <div class="nav_bar">
		<img src="${pageContext.request.contextPath}/img/avatar.png" class="mobile_profile_image" alt="">
		
        <i class="fa fa-bars nav_btn"></i>
      </div>
      <div class="mobile_nav_items">
        <a href="#"><i class="fas fa-desktop"></i><span>Dashboard</span></a>
        <a href="#"><i class="fas fa-cogs"></i><span>Components</span></a>
        <a ><i class="fas fa-table"></i><span>Tables</span></a>
        <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
        <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
        <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
      </div>
    </div>
    <!--mobile navigation bar end-->
    <!--sidebar start-->
    <div class="sidebar">
      <div class="profile_info">
     <img src="${pageContext.request.contextPath}/img/avatar.png" class="profile_image" alt="">
        
        <h4 style="color:white"><s:property value="userName"/></h4>
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


<h1>Ajouter mon enfant</h1>

<!--         <h4 style="color:white"><s:property value="userName" /></h4>
 -->
	 <s:form action="ChildRegistration">
	 
	    <s:hidden name="userName" value="%{#sessionUsername}"/>
	 
		<div class="inputs">
			<div class="input">
				<input placeholder="child firstname" name="child_firstname">
				<img src="./img/user.svg">
			</div>
			<div class="input">
				<input  placeholder="child lastname"  name="child_lastname">
				<img src="./img/user.svg">
			</div>
			<div class="input">
				<input  placeholder="child birth date"  name="child_bdate">
				<img src="./img/user.svg">
			</div>
		</div>
		<button type="submit" class="btn" value="ChildRegistration">Ajouter !</button>
	 </s:form>
	 
	 <style>

.align {
	height: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	padding-bottom: 8px;
}


.extend {
	max-height: 946px;
}

.head {
	width: 100%;
	display: flex;
	height: 72px;
	justify-content: space-between;
}

.head a {
	height: 100%;
	padding: 0 28px;
	display: flex;
	align-items: center;
	justify-content: center;
	color: rgb(140,140,140);
	font-size: 20px;
	font-weight: 500;
}

.head .selected {
	position: relative;
	color: #00FF5C;
	font-weight: 700;
}

.head .selected:after {
	position: absolute;
	content: "";
	bottom: 0;
	left: 0;
	height: 5px;
	width: 100%;
	background: #00FF5C;
	border-radius: 99px 99px 0 0;
}

.tabs {
	height: calc(100% - 72px);
	display: flex;
}

form {
	width: 60%;
	height: 100%;
	flex-shrink: 0;
	padding: 44px 38px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: center;
	position: relative;
	right: 0;
	transition: right 0.2s;
}

.extend form {
	right: 100%;
}

.inputs {
	width: 100%;
	padding-top: 6px;
}

.input {
	position: relative;
	margin-bottom: 20px;
	width: 100%;
	display: flex;
	align-items: center;
}

.input input {
	width: 100%;
	font-size: 17px;
	background: #1C1C1C;
	border-radius: 8px;
	padding: 16px 18px 16px 51px;
	color: rgb(220,220,220);
}

.input img {
	width: 16px;
	position: absolute;
	left: 19px;
}



 btn {
	display: block;
	background: #45f564;
	padding: 14px 52px;
	border-radius: 12px;
	color: white;
	font-weight: 700;
	font-size: 21px;
	cursor: pointer;
}
</style>
    </div>


  </body>
</html>
