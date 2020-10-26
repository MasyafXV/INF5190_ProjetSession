<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
  <head>
  	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <title>Admin menu</title>
    
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<link href="${pageContext.request.contextPath}/css/User_menu_style.css"
		rel="stylesheet" type="text/css" />
	<!-- <link href="${pageContext.request.contextPath}/css/Admin_menu_style.css"
		rel="stylesheet" type="text/css" /> -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		charset="utf-8">
	</script>
  </head>
  <body>

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
     <!--sidebar start-->
    <div class="sidebar">
      <div class="profile_info">
     <img src="${pageContext.request.contextPath}/img/logo.jpg" class="profile_image" alt="">
        
        <h4 style="color:white">Administrator</h4>
      </div>
      <a id="CreateSessionPage" href="<s:url action="ViewSession.action"></s:url>"><i class="fas fa-calendar"></i><span>Cr�er une session</span></a>
      <a id="CreateCoursePage" href="<s:url action="listSessions.action" ></s:url>"><i class="fas fa-table"></i><span>Ajouter un cours</span></a>      
      <a id="RegisterChildPage" href="<s:url action="redirectAddChild.action" ></s:url>"><i class="fas fa-graduation-cap"></i><span>Noter les nageurs</span></a>
      <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
      </div>
    <!--sidebar end-->
    

    <div class="content"><!-- 
    	<div class="contentSession">
    		<h2>View session</h2>
    	<p><a href="<s:url action='ViewSession'/>">Liste des sessions</a></p>
    	</div>
    	-->
    	
    </div>

  </body>
</html>
