
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
	<br/>

		<h1>Noter les nageurs</h1>


		<div class="CourseSelection">
			<s:form action="ListGrades" name="SelectCourse">

				<div class="select">
					<select name="courseCode" id="format" onchange="setValueCourseCode(this)">
						<option selected disabled>Choisissez un cours</option>
						
						<c:forEach items="${coursesList}" var="course">
							<option value="${course.courseLevel}">
								<c:out value="${course.sessionCode}"/>-<c:out value="${course.courseLevel}"/>
							</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="buttons">
				  <div class="button-container">
				          <button class="btn effect01" type="submit" class="btn">OK</button>
				  </div>
				</div>
		</s:form>
    </div>
    <script type="text/javascript">
		function setValueCourseCode(selectCourse) {
			let text = selectCourse.options[selectCourse.selectedIndex].text;
			selectCourse.options[selectCourse.selectedIndex].value = text;
		}
	</script>
		<div class=GradeSwimmer>
			<h1>Noter les nageurs du cour : <c:out value="${courseCode}"/></h1>
			<s:form action="gradeSwimmer">
			<s:textfield id="hidden" name="courseCode" cssClass="textfield" cssStyle="display:none;"><c:out value="${courseCode}"/></s:textfield>
			<table>
					<tr>
						<th>Nom</th>
						<th>Commentaires</th>
						<th>Note</th>
					</tr>
				<s:iterator value="listGrades">
					<tr>
						<td><s:property value="personName"/></td>
						<td><textarea><s:property value="comments"/></textarea></td>
						<td>
							<select name="grade">
								<option selected value="<s:property value="grade"/>"><s:property value="grade"/></option>
								<option value="Succes">Succes</option>
								<option value="Echec">Echec</option>
							</select>
						</td>
					</tr>
				</s:iterator>
			</table>
			<button type="submit" class="button"><i class="fa fa-check-square"></i>Noter</button>
			</s:form>
		</div>
	
	
	
    </div>

  </body>
</html>

