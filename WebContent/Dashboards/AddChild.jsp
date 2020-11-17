<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <% HttpSession sess = request.getSession(true);
    if (sess.getAttribute("userName")==null)
    {
        response.sendRedirect("http://localhost:8080/INF5190_ProjetSession/Login");
    }
%>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Menu</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/User_menu_style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
    	 <style>
.form__group {
  position: relative;
  padding: 15px 0 0;
  margin-top: 10px;
  width: 50%;
}

.form__field {
  font-family: inherit;
  width: 100%;
  border: 0;
  border-bottom: 2px solid #9b9b9b;
  outline: 0;
  font-size: 1.3rem;
  color: #9b9b9b;
  padding: 7px 0;
  background: transparent;
  transition: border-color 0.2s;
}
.form__field::placeholder {
  color: transparent;
}
.form__field:placeholder-shown ~ .form__label {
  font-size: 1.3rem;
  cursor: text;
  top: 20px;
}

.form__label {
  position: absolute;
  top: 0;
  display: block;
  transition: 0.2s;
  font-size: 1rem;
  color: #9b9b9b;
}

.form__field:focus {
  padding-bottom: 6px;
  font-weight: 700;
  border-width: 3px;
  border-image: linear-gradient(to right, #11998e, #38ef7d);
  border-image-slice: 1;
}
.form__field:focus ~ .form__label {
  position: absolute;
  top: 0;
  display: block;
  transition: 0.2s;
  font-size: 1rem;
  color: #11998e;
  font-weight: 700;
}

/* reset input */
.form__field:required, .form__field:invalid {
  box-shadow: none;
}
		</style>
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
        
        			        <h4 style="color:white">${sessionScope.userName}</h4>

		<s:set var="sessionUsername" value="userName" />
      </div>
      <a id="RegisterUserCoursePage" href="<s:url action="InitUserCourseInscription.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i class="fas fa-desktop"></i><span>S'inscrire a un cours</span></a>
      <a id="RegisterChildCoursePage" href="<s:url action="InitChildCourseInscription.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i class="fas fa-cogs"></i><span>Inscrire mon enfant</span></a>      
      <a id="RegisterChildPage" href="<s:url action="redirectAddChild.action" ><s:param name="userName" value="sessionUsername"/></s:url>"><i class="fas fa-table"></i><span>Ajouter un enfant</span></a>
      <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
      </div>
    <!--sidebar end-->

    <div class="content">

			  <br>

<h1>Ajouter mon enfant</h1>
			  <br>

 <s:form action="ChildRegistration">
	 
	    <s:hidden name="userName" value="%{#sessionUsername}"/>
	    
			<div class="form__group field">
			  <input type="input" class="form__field" placeholder="Name" name="child_firstname" id='name' required />
			  <label for="name" class="form__label">child first name</label>
			</div>
			<div class="form__group field">
			  <input type="input" class="form__field" placeholder="Name" name="child_lastname" id='name' required />
			  <label for="name" class="form__label">child last name</label>
			</div>
			<div class="form__group field">
			  <input type="input" class="form__field" placeholder="Name" name="child_bdate" id='name' required />
			  <label for="name" class="form__label">child bdate</label>
			</div>
			<br/>
			
			<div class="buttons">
				  <div class="button-container">
				          <button class="btn effect01" type="submit" class="btn" value="ChildRegistration">Ajouter !</button>
				  </div>
				</div>
			 </s:form> 
	</div>

  </body>
</html>
