<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
  <head>
  	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <title>Admin - Create Course</title>
    
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<link href="${pageContext.request.contextPath}/css/User_menu_style.css"
		rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/Admin_menu_style.css"
		rel="stylesheet" type="text/css" />
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		charset="utf-8">
	</script>
  </head>
  <body>

	<s:url action="listSessions"/>

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
      <a id="CreateSessionPage" href="<s:url action="ViewSession.action"></s:url>"><i class="fas fa-calendar"></i><span>Créer une session</span></a>
      <a id="CreateCoursePage" href="<s:url action="listSessions.action" ></s:url>"><i class="fas fa-table"></i><span>Ajouter un cours</span></a>      
      <a id="RegisterChildPage" href="<s:url action="redirectAddChild.action" ></s:url>"><i class="fas fa-graduation-cap"></i><span>Noter les nageurs</span></a>
      <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
      </div>
    <!--sidebar end-->
    

    <div class="content">
    	<h1>Ajouter un cours une session</h1>

		<div class="CourseSelection">

			<s:form action="CreateCourse">
				<div class="select">
						<select name="newCourse.SessionCode" id="format">
							<option selected disabled>Choisissez une session</option>
							
							<c:forEach items="${listSessions}" var="session">
								<option value="${session.code}">
									<c:out value="${session.code}"/> <c:out value="${session.season}"/> <c:out value="${session.year}"/>
								</option>
							</c:forEach>
						</select>
				</div>
				<br/>
				<br/>
				<div class="select">
					<select name="newCourse.CourseLevel" id="format">
						<option selected disabled>Choisissez un cours</option>
						<option value="Etoile_de_mer">Étoile de mer</option>
						<option value="Bambins">Bambins</option>
						<option value="Tortues">Tortues</option>
						<option value="Pingouins">Pingouins</option>
						<option value="Salamandre">Salamandre</option>
						<option value="Baleines">Baleines</option>
						<option value="Grenouilles">Grenouilles</option>
						<option value="Dauphins">Dauphins</option>
						<option value="Junior1">Junior1</option>
						<option value="Junior2">Junior2</option>
						<option value="Junior3">Junior3</option>
						<option value="Junior4">Junior4</option>
						<option value="Junior5">Junior5</option>
						<option value="Maitre_Nageur">Maître-Nageur</option>
					</select>
				</div>
				<br/>
				<br/>
				<div class="textfield">
					<textarea name="newCourse.Description" id="format" placeholder="Inscrivez la description du cours"></textarea>
				</div>
				<br/>
				<br/>
				<div class="textfield">
					<textarea name="newCourse.NbPlace" id="format" placeholder="Inscrivez le nombre de place disponible pour ce cours"></textarea>
				</div>
				<br/>
				<br/>
				<div class="textfield">
					<textarea name="newCourse.price" id="format" placeholder="Inscrivez le prix du cours"></textarea>
				</div>
				<br/>
				<br/>
				<button type="submit" class="button"><i class="fa fa-check-square"></i>Ajouter</button>

			</s:form>
    	</div>
    	
    </div>

  </body>
</html>
