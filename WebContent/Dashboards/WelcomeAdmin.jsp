<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Admin menu</title>
    <link rel="stylesheet" href="../css/User_menu_style.css">
    <link rel="stylesheet" href="../css/Admin_menu_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
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
      <center>
        <img src="./img/logo.jpg" class="profile_image" alt="">
        <h4>Administrator</h4>
      </center>
      <a href="#"><i class="fas fa-id-card"></i><span> Information </span></a>
      <a href="CreateSession.jsp"><i class="fas fa-calendar"></i><span> Créer une session </span></a>
      <a href="#"><i class="fas fa-table"></i><span> Ajouter un cours </span></a>
      <a href="#"><i class="fas fa-graduation-cap"></i><span>Notez les nageurs</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
    </div>
    <!--sidebar end-->
    

    <div class="content">
    	<div class="contentSession">
    		<h2>View session</h2>
    	<p><a href="<s:url action='viewSession'/>">Liste des sessions</a></p>
    	</div>
    	
    	
    </div>

  </body>
</html>
