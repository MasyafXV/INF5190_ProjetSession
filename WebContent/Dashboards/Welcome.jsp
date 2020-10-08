<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>User menu</title>
    <link href="${pageContext.request.contextPath}/css/User_menu_style.css" rel="stylesheet" type="text/css"/>
    
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
        <img src="${pageContext.request.contextPath}/img/avatar.png" class="profile_image" alt="">
        <h4><s:property value="userName"/></h4>
      </center>
      <a href="#"><i class="fas fa-desktop"></i><span>S'inscrire a un cours </span></a>
      <a href="#"><i class="fas fa-cogs"></i><span>Inscrire mon enfant </span></a>
      <a href="#"><i class="fas fa-table"></i><span>Fonction 3 </span></a>
      <a href="#"><i class="fas fa-th"></i><span>Fonction 4 </span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
    </div>
    <!--sidebar end-->
    

    <div class="content"></div>

  </body>
</html>
