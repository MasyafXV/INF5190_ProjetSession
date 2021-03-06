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
    <link href="${pageContext.request.contextPath}/css/Admin_menu_style.css" rel="stylesheet" type="text/css" />
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

    </div>
    <!--mobile navigation bar end-->
    <!--sidebar start-->
    <div class="sidebar">
      <div class="profile_info">
     <img src="${pageContext.request.contextPath}/img/logo.jpg" class="profile_image" alt="">
        
        <h4 style="color:white">Administrator</h4>
      </div>
      <a id="CreateSessionPage" href="<s:url action="ViewSession.action"></s:url>"><i class="fas fa-calendar"></i><span>Cr�er une session</span></a>
      <a id="CreateCoursePage" href="<s:url action="listSessions.action" ></s:url>"><i class="fas fa-table"></i><span>Ajouter un cours</span></a>      
      <a id="RegisterChildPage" href="<s:url action="ListCoursesForGrades.action" ></s:url>"><i class="fas fa-graduation-cap"></i><span>Noter les nageurs</span></a>
      <a href="#"><i class="fas fa-th"></i><span>Forms</span></a>
      <a href="#"><i class="fas fa-info-circle"></i><span>About</span></a>
      <a href="#"><i class="fas fa-sliders-h"></i><span>Settings</span></a>
      </div>
    <!--sidebar end-->

    <div class="content">

    <div class="contentSession">    		
    		<table class="tab">
					<tr>
						<th>Code Session</th>
						<th>Nom Session</th>
						<th>D�but de session</th>
						<th>Fin de session</th>
					</tr>
    		<s:iterator value="listSessions" var="session">
    			<tr>
					<td><s:property value="#session.code"/></td>
					<td>
						<s:property value="#session.season"/>
						<s:property value="#session.year"/>
					</td>
					<td><s:property value="#session.sessionFrom"/></td>
					<td><s:property value="#session.sessionTo"/></td>
				</tr>
			</s:iterator>
			</table>
		<h2>Cr�er une nouvelle session</h2>
    	<s:form action="CreateNewSession" name="ajouterSession" onsubmit="return validForm()">
				<s:textfield cssClass="textfield" name="newSession.code" cssStyle="display:none;"/>
				<div class="select">
					<select name="newSession.season" id="format">
						<option selected disabled>Choisissez une saison</option>
						<option value="Hiver">Hiver</option>
						<option value="Ete">�t�</option>
						<option value="Automne">Automne</option>
					</select>
				</div>
				<s:textfield class="textfield" name="newSession.year" placeholder="Ann�e : YYYY" />
				<s:textfield class="textfield" name="newSession.sessionFrom" placeholder="D�but : DD/MM/YYYY " />
				<s:textfield class="textfield" name="newSession.sessionTo" placeholder="Fin : DD/MM/YYYY --" />
				<div class="buttons">
				  <div class="button-container">
				          <s:submit cssClass="btn effect01" value="Ajouter"></s:submit>
				  </div>
				</div>
    	</s:form>
    	<h2 id="errorMsg" class="error"></h2>
    	
    	</div>
    	
    	    	<script type="text/javascript">
    		function validForm() {
    			let season = document.forms['ajouterSession']['newSession.season'].value;
    			let year = document.forms['ajouterSession']['newSession.year'].value.trim();
    			let sessionFrom = document.forms['ajouterSession']['newSession.sessionFrom'].value.trim();
    			let sessionTo = document.forms['ajouterSession']['newSession.sessionTo'].value.trim();
    			
    			let yearFormat = /^[0-9]{4}$/g;
    			let dateFormat = /^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$/g;
    			
    			let invalide = season == "" || year == "" || sessionFrom == "" || sessionTo == "";
    			
    			if (invalide) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez remplir tout le formulaire";
    				return false;
    			}
    			else if (!year.match(yearFormat)) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez mettre l'ann� au bon format (YYYY)";
    				return false;
    			}
    			else if (!sessionFrom.match(dateFormat)) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez mettre la date de d�but de session au bon format (DD/MM/YYYY)";
    				return false;
    			} 
    			else if (!sessionTo.match(dateFormat)) {
    				document.getElementById("errorMsg").innerHTML = "Veuillez mettre la date de fin de session au bon format (DD/MM/YYYY)";
    				return false;
    			} 
    			
    			let firstLetterCode = season.substring(0, 1);
        		let yearCode = year.slice(-2);
        		let code = firstLetterCode+''+yearCode;
        		document.forms['ajouterSession']['newSession.code'].value = code;
        		document.forms['ajouterSession']['newSession.year'].value = year;
        		document.forms['ajouterSession']['newSession.sessionFrom'].value = sessionFrom;
        		document.forms['ajouterSession']['newSession.sessionTo'].value = sessionTo;
    		}
    	</script>
    </div>

  </body>
</html>


