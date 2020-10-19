<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.pronatation.Child.ChildBean"%>
<%@page import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Pour l'itération, il faut spécifier le type de données -->
<jsp:useBean id="childsList" type="java.util.ArrayList<com.pronatation.Child.ChildBean>" scope="request" />


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
      <a id="RegisterUserCoursePage" href="#"><i class="fas fa-desktop"></i><span>S'inscrire a un cours</span></a>
      <a id="RegisterChildCoursePage" href="#"><i class="fas fa-cogs"></i><span>Inscrire mon enfant</span></a>
      <a id="RegisterChildPage" href="#"><i class="fas fa-table"></i><span>Ajouter un enfant</span></a>
      <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
    </div>
    <!--sidebar end-->

    <div class="content">

       <div id="AddMyChild" class="card" style="display: none;">
     		<%@ include file="FamilyManagerView.jsp"%> 
     </div> 
      <div id="RegisterChildToCourse" class="card" style="display: none;">
     		<%@ include file="ChildCourseRegistration.jsp"%> 
     </div>  
     <div id="RegisterUserToCourse" class="card" style="display: none;">
     		<%@ include file="UserCourseRegistration.jsp"%> 
     </div> 
     
<!--      test
 -->        <c:forEach items="${childsList}" var="child">
           <c:out value="${child.childName}"/>
        </c:forEach>
    </div>

    <script type="text/javascript">
    $(document).ready(function(){
      $('.nav_btn').click(function(){
        $('.mobile_nav_items').toggleClass('active');
      });
    });
    
    jQuery(document).ready(function($) {
        $('#RegisterChildPage').on('click', function() {
            $('#RegisterUserToCourse').hide();
            $('#RegisterChildToCourse').hide();
            $('#AddMyChild').show();


        });
    });
    
    jQuery(document).ready(function($) {
        $('#RegisterChildCoursePage').on('click', function() {
            $('#AddMyChild').hide();
            $('#RegisterUserToCourse').hide();
            $('#RegisterChildToCourse').show();

        });
    });
    
    jQuery(document).ready(function($) {
        $('#RegisterUserCoursePage').on('click', function() {
            $('#AddMyChild').hide();
            $('#RegisterChildToCourse').hide();
            $('#RegisterUserToCourse').show();


        });
    });
    </script>

  </body>
</html>
